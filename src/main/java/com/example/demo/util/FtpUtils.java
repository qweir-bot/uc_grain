package com.example.demo.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.SocketException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class FtpUtils {

    private static final Logger logger = LoggerFactory.getLogger(FtpUtils.class);

    private static final Integer URL_PRIFX = 6;

    private static final String ROOT_PATH = "/asia/aiftp";

    /**
     * 获取ftp连接
     *
     * @param ftpHost
     * @param ftpUserName
     * @param ftpPassword
     * @param ftpPort
     * @return
     */
    public static FTPClient getFTPClient(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(ftpHost, ftpPort);
            ftpClient.login(ftpUserName, ftpPassword);
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                logger.error("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                logger.error("FTP连接成功。");
            }
        } catch (SocketException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return ftpClient;
    }

    /**
     * 文件上传
     * @param ftpHost
     * @param ftpUserName
     * @param ftpPassword
     * @param ftpPort
     * @param ftpPath
     * @param fileName
     * @param inputStream
     * @param ftpMode
     * @return
     */
    public static boolean upload(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort, String ftpPath, String fileName, InputStream inputStream, String ftpMode) {
        boolean isSuccess = false;
        FTPClient ftpClient = null;
        try {
//            logger.error("====ftpHost:" + ftpHost + ";ftpUserName:" + ftpUserName + ";ftpPassword:" + ftpPassword+";ftpPort:" + ftpPort);
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            if(Constants.FTP_ACTIVE.equals(ftpMode)){
                ftpClient.enterLocalActiveMode();
            }else{
                ftpClient.enterLocalPassiveMode();
            }
            if (StringUtils.isNotEmpty(ftpPath)) {
                changeDir(ftpClient,ftpPath);
            }
            isSuccess = ftpClient.storeFile(fileName, inputStream);
            if (isSuccess) {
                logger.info("上传文件:{}成功", fileName);
            } else {
                logger.info("上传文件:{}失败", fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != ftpClient){
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return isSuccess;
    }

    /**
     * 文件上传
     * @param ftpHost
     * @param ftpUserName
     * @param ftpPassword
     * @param ftpPort
     * @param ftpPath
     * @param fileName
     * @param file
     * @param ftpMode
     * @return
     */
    public static boolean upload(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort, String ftpPath, String fileName, File file,String ftpMode) {
        boolean isSuccess = false;
        FTPClient ftpClient = null;
        FileInputStream inputStream = null;
        try {
//            logger.error("====ftpHost:" + ftpHost + ";ftpUserName:" + ftpUserName + ";ftpPassword:" + ftpPassword+";ftpPort:" + ftpPort);
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            if(Constants.FTP_ACTIVE.equals(ftpMode)){
                ftpClient.enterLocalActiveMode();
            }else{
                ftpClient.enterLocalPassiveMode();
            }
            if (StringUtils.isNotEmpty(ftpPath)) {
                changeDir(ftpClient,ftpPath);
            }
            inputStream = new FileInputStream(file);
            isSuccess = ftpClient.storeFile(fileName, inputStream);
            if (isSuccess) {
                logger.info("上传文件:{}成功", fileName);
            } else {
                logger.info("上传文件:{}失败", fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != ftpClient){
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return isSuccess;
    }

    /**
     *
     * @param ftpHost
     * @param ftpUserName
     * @param ftpPassword
     * @param ftpPort
     * @param ftpPath
     * @param localPath
     * @param fileName
     * @param ftpMode
     * @return
     */
    public static boolean download(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort, String ftpPath, String localPath, String fileName,String ftpMode) {
        boolean isSuccess = false;
        FTPClient ftpClient = null;
        OutputStream os = null;
        try {
//            logger.error("====ftpHost:" + ftpHost + ";ftpUserName:" + ftpUserName + ";ftpPassword:" + ftpPassword+";ftpPort:" + ftpPort);
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            if(Constants.FTP_ACTIVE.equals(ftpMode)){
                ftpClient.enterLocalActiveMode();
            }else{
                ftpClient.enterLocalPassiveMode();
            }
            if(StringUtils.isNotBlank(ftpPath)){
                changeDir(ftpClient,ftpPath);
            }
            os = new FileOutputStream(new File(localPath));
            isSuccess = ftpClient.retrieveFile(fileName, os);
            os.flush();
        } catch (FileNotFoundException e) {
            logger.error("没有找到" + ftpPath + "文件");
            logger.error(e.getMessage(), e);
        } catch (SocketException e) {
            logger.error("连接FTP失败.");
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error("文件读取错误。");
            logger.error(e.getMessage(), e);
        } finally {
            logger.error("ftpDownload finally");
            logger.error("ftp download file size:"+ FileUtils.sizeOf(new File(localPath)));
            try {
                if(null != os){
                    os.close();
                }
                if(null != ftpClient){
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return isSuccess;
    }

    /**
     * 文件删除
     * @param ftpHost
     * @param ftpUserName
     * @param ftpPassword
     * @param ftpPort
     * @param ftpPath
     * @param fileName
     * @param ftpMode
     * @return
     */
    public static boolean delete(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort, String ftpPath, String fileName,String ftpMode) {
        boolean isSuccess = false;
        FTPClient ftpClient = null;
        try {
//            logger.error("====ftpHost:" + ftpHost + ";ftpUserName:" + ftpUserName + ";ftpPassword:" + ftpPassword+";ftpPort:" + ftpPort);
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            if(Constants.FTP_ACTIVE.equals(ftpMode)){
                ftpClient.enterLocalActiveMode();
            }else{
                ftpClient.enterLocalPassiveMode();
            }
            if(StringUtils.isNotBlank(ftpPath)){
                changeDir(ftpClient,ftpPath);
            }
            isSuccess = ftpClient.deleteFile(fileName);
        } catch (FileNotFoundException e) {
            logger.error("没有找到" + ftpPath + "文件");
            logger.error(e.getMessage(), e);
        } catch (SocketException e) {
            logger.error("连接FTP失败.");
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error("文件读取错误。");
            logger.error(e.getMessage(), e);
        } finally {
            try {
                if(null != ftpClient){
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return isSuccess;
    }

    /**
     * 解析ftp登录信息
     * @param src ftp://icd:Admin12%@172.20.48.9:21/share1/1/0/20180123/1348/0154262.V3
     * @return
     */
    public static Map<String,Object> splitFtpInfoByUrl(String src) {
        Map<String, Object> info = new HashMap<String, Object>();
        if (StringUtils.isBlank(src)) {
            return info;
        }
        try {
            String url = src.substring(URL_PRIFX);
            int indexParam = url.indexOf("/");
            String loginStr = url.substring(0, indexParam);
            indexParam = url.lastIndexOf("/");
            String fileDir = url.substring(url.indexOf("/"), indexParam);
            String fileNm = url.substring(indexParam + 1);
            indexParam = loginStr.lastIndexOf("@");
            String userStr = loginStr.substring(0, indexParam);
            String srvStr = loginStr.substring(indexParam + 1);
            indexParam = userStr.indexOf(":");
            String userNm = userStr.substring(0, indexParam);
            String pwd = userStr.substring(indexParam + 1);
            indexParam = srvStr.indexOf(":");
            String ip = srvStr.substring(0, indexParam);
            String port = srvStr.substring(indexParam + 1);

            info.put("ftpUserName", userNm);
            info.put("ftpPassword", URLDecoder.decode(pwd, "UTF-8"));
            info.put("ftpHost", ip);
            info.put("ftpPort", port);
            info.put("ftpPath", fileDir);
            info.put("fileName", fileNm);
        } catch (Exception e) {
            logger.error("============解析ftp信息错误：" + e.getMessage(), e);
        }
        return info;
    }

    public static boolean changeDir(FTPClient ftpClient, String path)throws IOException{
        if(StringUtils.isNotBlank(path)){
            String[] paths = path.split("/");
            if(paths.length>0){
//                ftpClient.changeWorkingDirectory(ROOT_PATH);
                for(String pathName : paths){
                    if(StringUtils.isNotBlank(pathName)){
                        if(!ftpClient.changeWorkingDirectory(pathName)){
                            ftpClient.makeDirectory(pathName);
                            ftpClient.changeWorkingDirectory(pathName);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static String oaDownload(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort, String ftpPath, String localPath, String fileName,String ftpMode) {
        boolean isSuccess = false;
        FTPClient ftpClient = null;
        FileInputStream inputFile = null;
        OutputStream os = null;
        String tempFileString = "";
        try {
//            logger.error("====ftpHost:" + ftpHost + ";ftpUserName:" + ftpUserName + ";ftpPassword:" + ftpPassword+";ftpPort:" + ftpPort);
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            if(Constants.FTP_ACTIVE.equals(ftpMode)){
                ftpClient.enterLocalActiveMode();
            }else{
                ftpClient.enterLocalPassiveMode();
            }
            if(StringUtils.isNotBlank(ftpPath)){
                changeDir(ftpClient,ftpPath);
            }
            File file = new File(localPath);
            os = new FileOutputStream(new File(localPath));
            ftpClient.retrieveFile(fileName, os);
            os.flush();
            inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            tempFileString = Base64.getEncoder().encodeToString(buffer);
        } catch (FileNotFoundException e) {
            logger.error("没有找到" + ftpPath + "文件");
            logger.error(e.getMessage(), e);
        } catch (SocketException e) {
            logger.error("连接FTP失败.");
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error("文件读取错误。");
            logger.error(e.getMessage(), e);
        } finally {
            logger.error("ftpDownload finally");
            logger.error("ftp download file size:"+ FileUtils.sizeOf(new File(localPath)));
            try {
                if(null != os){
                    os.close();
                }
                if(null != inputFile){
                    inputFile.close();
                }
                if(null != ftpClient){
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return tempFileString;
    }
}
