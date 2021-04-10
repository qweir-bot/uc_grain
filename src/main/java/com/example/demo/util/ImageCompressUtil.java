package com.example.demo.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


public class ImageCompressUtil {


    private static final Logger logger = LoggerFactory.getLogger(ImageCompressUtil.class);

    public static byte[] compressImage(byte[] data) {
        return compressImage(data, 600, 400, 0.85f);
    }

    public static byte[] compressImage(byte[] data, int width, int height) {
        return compressImage(data, width, height, 0.85f);
    }

    public static byte[] compressImage(byte[] data, int width, int height, float quality) {
        width = width > 600 ? 600 : width;//限定宽度为600
        height = height > 400 ? 400 : height;//限定高度为400
        quality = quality < 0.8f ? 0.8f : quality;
        int maxLength = 71 * 1024;//70K以下不压缩
        if (data == null || data.length < maxLength) {
            return data;
        }
        try {
            InputStream inputStream = new ByteArrayInputStream(data);
            Image oriImg = ImageIO.read(inputStream);
            int ori_width = oriImg.getWidth(null);
            int ori_height = oriImg.getHeight(null);
            if (width > ori_width || height > ori_height) {
                return data;
            }
            float ori_rate = (float) ori_width / (float) ori_height;
            float rate = (float) width / (float) height;
            if (ori_rate > rate) {
                return compressByWidth(ori_width, ori_height, width, oriImg, quality);
            } else {
                return compressByHeight(ori_width, ori_height, height, oriImg, quality);
            }
        } catch (IOException e) {
            logger.error("ImageCompressUtil compressImage IOException failed,", e);
        }
        logger.warn("ImageCompressUtil compressImage failed,now return the origin data.");
        return data;
    }

    /**
     * 以宽度为基准，等比例放缩图片
     *
     * @param w int 新宽度
     */
    private static byte[] compressByWidth(int ori_width, int ori_height, int w, Image oriImg, float quality) throws IOException {
        int h = (int) (ori_height * w / ori_width);
        return compress(w, h, oriImg, quality);
    }

    /**
     * 以高度为基准，等比例缩放图片
     *
     * @param h int 新高度
     */
    private static byte[] compressByHeight(int ori_width, int ori_height, int h, Image oriImg, float quality) throws IOException {
        int w = (int) (ori_width * h / ori_height);
        return compress(w, h, oriImg, quality);
    }

    /**
     * 压缩/放大图片到固定的大小
     *
     * @param w int 新宽度
     * @param h int 新高度
     */
    private static byte[] compress(int w, int h, Image oriImg, float quality) throws IOException {

        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢  
        //image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图  
        image.getGraphics().drawImage(oriImg.getScaledInstance(w, h, Image.SCALE_SMOOTH), 0, 0, null);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 可以正常实现bmp、png、gif转jpg  
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(image);
        /* 压缩质量 */
        jep.setQuality(quality, true);
        encoder.encode(image, jep);// JPEG编码  
        return out.toByteArray();
    }

    /**
     * 将文件转换成byte数组
     * @param filePath
     * @return
     */
    public static byte[] File2byte(File tradeFile){
        byte[] buffer = null;
        try
        {
            FileInputStream fis = new FileInputStream(tradeFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return buffer;
    }

    public static void getFileByBytes(byte[] bytes, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            // 判断文件目录是否存在
            if (!dir.exists() && dir.isDirectory()) {
                dir.mkdirs();
            }
            file = new File(filePath + "\\" + fileName);

            //输出流
            fos = new FileOutputStream(file);

            //缓冲流
            bos = new BufferedOutputStream(fos);

            //将字节数组写出
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 指定图片宽度和高度和压缩比例对图片进行压缩
     *
     * @param imgsrc 源图片地址
     * @param imgdist 目标图片地址
     */
    public static void reduceImg(String imgsrc, String imgdist) {
        try {
            File srcfile = new File(imgsrc);
            // 检查图片文件是否存在
            if (!srcfile.exists()) {
                System.out.println("文件不存在");
            }
            int[] results = getImgWidthHeight(srcfile);

            int widthdist = results[0];
            int heightdist = results[1];
            // 开始读取文件并进行压缩
            Image src = ImageIO.read(srcfile);

            // 构造一个类型为预定义图像类型之一的 BufferedImage
            BufferedImage tag = new BufferedImage( widthdist,  heightdist, BufferedImage.TYPE_INT_RGB);

            // 这边是压缩的模式设置
            tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH), 0, 0, null);

            //创建文件输出流
            FileOutputStream out = new FileOutputStream(imgdist);
            //将图片按JPEG压缩，保存到out中
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            //关闭文件输出流
            out.close();
        } catch (Exception ef) {
            ef.printStackTrace();
        }
    }

    /**
     * 获取图片宽度和高度
     *
     * @param file 图片路径
     * @return 返回图片的宽度
     */
    public static int[] getImgWidthHeight(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int result[] = { 0, 0 };
        try {
            // 获得文件输入流
            is = new FileInputStream(file);
            // 从流里将图片写入缓冲图片区
            src = ImageIO.read(is);
            // 得到源图片宽
            result[0] =src.getWidth(null);
            // 得到源图片高
            result[1] =src.getHeight(null);
            is.close();  //关闭输入流
        } catch (Exception ef) {
            ef.printStackTrace();
        }

        return result;
    }


    public static void  compressPic(String srcFilePath, String descFilePath, Float quality) throws IOException {
        File input = new File(srcFilePath);
        BufferedImage image = ImageIO.read(input);

        // 指定写图片的方式为 jpg
        ImageWriter writer =  ImageIO.getImageWritersByFormatName("jpg").next();

        // 先指定Output，才能调用writer.write方法
        File output = new File(descFilePath);
        OutputStream out = new FileOutputStream(output);
        ImageOutputStream ios = ImageIO.createImageOutputStream(out);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();
        if (param.canWriteCompressed()){
            // 指定压缩方式为MODE_EXPLICIT
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            // 压缩程度，参数qality是取值0~1范围内
            param.setCompressionQuality(quality);
        }
        // 调用write方法，向输入流写图片
        writer.write(null, new IIOImage(image, null, null), param);

        out.close();
        ios.close();
        writer.dispose();
    }
} 