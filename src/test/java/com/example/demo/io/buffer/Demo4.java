package com.example.demo.io.buffer;

import java.io.*;

/**
 * 1.流向:输入流，输出流
 * 2.数据：字节流，二进制，可以处理所有数据
 * 字符流：纯文本
 * 3.功能：节点
 * 处理：增强功能，提高性能
 * 字节流：InputStream :
 * FileInputStream
 * OutputStream :
 * FileOutputStream
 *
 * 字节流
 * 输入流：Reader
 * FileReader
 * 输出流： Writer
 * FileWriter
 *处理流：
 * BufferedInputStream
 * BufferedOutputtream
 * 1.建立联系
 * 2.选择流
 * 操作 数组大小read write
 * 释放流
 */

public class Demo4 {
    public static void main(String[] args){
        String parentPath = "E:/test/2.txt";
        //建立联系
        File f1 = new File(parentPath);
        FileInputStream fileInputStream = null;
        FileOutputStream os = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            os = new FileOutputStream("E:/test/3.txt",true);

            br = new BufferedReader(new FileReader(f1));
            bw = new BufferedWriter(new FileWriter("E:/test/5.txt"));
            String line = null;
            while (null!=(line = br.readLine())){
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
            //选择流
            fileInputStream = new FileInputStream(f1);
            byte[] car = new byte[10];
            int len = 0;
            while (-1!=(len = fileInputStream.read(car))){
//                String info = new String(car,0,len);
//                System.out.println(info);
//                os.write(info.getBytes(),0,info.length());
                os.write(car,0,len);
                os.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //
        System.out.println(f1.length());
    }
}
