package com.example.demo.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class ZipUtils {
    private static final Logger logger = LoggerFactory.getLogger(ZipUtils.class);

    /**
     * 批量打包
     *
     * @param jsonString json格式字符串数据
     * @param fileSaveRootPath 项目根目录
     * @return zip文件保存绝对路径
     */
    public String createZipAndReturnPath(String jsonString, String fileSaveRootPath) {

        //生成jsonArray列表
        JSONArray jsonArray = JSONArray.fromObject(jsonString);

        try {
            //生成打包下载后的zip文件:Papers.zip
            String papersZipName = "Papers.zip";

            //zip文件保存路径
            String zipPath = fileSaveRootPath + papersZipName;

            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipPath));

            //查询ftp登录信息
            Map<String, Object> temp = new HashMap<>();
            temp.put("codeTypeCd", "FTP_CONFIG");
//            TWfCfgCodeService tWfCfgCodeService = SpringContextUtils.getBean(TWfCfgCodeService.class);
//            List<TWfCfgCode> ctpConfigList = tWfCfgCodeService.getByCodeType(temp);
            List<Map> ctpConfigList = new ArrayList<>();
            if (CollectionUtils.isEmpty(ctpConfigList)) {
                logger.error("获取ftp登录信息为空");
                return null;
            }
//            TWfCfgCode tWfCfgCode = ctpConfigList.get(0);
//            String ftpUrl = tWfCfgCode.getBizCode();
//            String ftpMode = tWfCfgCode.getSuprBizCode();
            String ftpUrl = "";
            String ftpMode = "";
            Map<String, Object> ftpConfig = FtpUtils.splitFtpInfoByUrl(ftpUrl);
            if (MapUtils.isEmpty(ftpConfig)) {
                logger.error("获取ftp登录信息为空");
                return null;
            }
            String ftpHost = MapUtils.getString(ftpConfig, "ftpHost");
            String ftpUserName = MapUtils.getString(ftpConfig, "ftpUserName");
            String ftpPassword = MapUtils.getString(ftpConfig, "ftpPassword");
            int ftpPort = MapUtils.getIntValue(ftpConfig, "ftpPort");
            String ftpPath = MapUtils.getString(ftpConfig, "ftpPath");

            String[] fileNames = new String[jsonArray.size()];

            //遍历jsonArray列表获取所有JSONObject对象
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                //获得文件相关信息
                String fileId = jsonObject.getString("fileId");
                String fileName = jsonObject.getString("fileName");

                Map<String,Object> repeatMap = new HashMap<>();
                repeatMap.put("fileName",fileName);
                repeatMap.put("repeatTimes",1);
                repeatMap = checkRepeatFileName(fileName,fileNames,repeatMap);
                fileName = MapUtils.getString(repeatMap,"fileName");
                fileNames[i] = fileName;
                long crtTime = jsonObject.getLong("crtTime");

                String relativePath = ftpPath + "/" + DateUtils.date2String(new Date(crtTime),DateUtils.DATE_PATTERN.YYYYMM);

                FtpUtils.download(ftpHost, ftpUserName, ftpPassword, ftpPort, relativePath, fileId, fileId, ftpMode);

                FileInputStream fis = new FileInputStream(fileId);
                out.putNextEntry(new ZipEntry(fileName));

                //写入压缩包
                int len;
                byte[] buffer = new byte[1024];
                while ((len = fis.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                out.closeEntry();
                fis.close();
                FileUtils.deleteQuietly(new File(fileId));
            }
            out.close();
            out.flush();
            return zipPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, Object> checkRepeatFileName(String originfileName,String[] fileNames,Map<String, Object> repeatMap){
        String fileName = MapUtils.getString(repeatMap,"fileName");
        int repeatTimes = MapUtils.getIntValue(repeatMap,"repeatTimes");
        if(ArrayUtils.contains(fileNames,fileName)){
            fileName = originfileName.substring(0,originfileName.lastIndexOf("."))+"("+repeatTimes+")"+originfileName.substring(originfileName.lastIndexOf("."));
            repeatMap.put("fileName",fileName);
            if(ArrayUtils.contains(fileNames,fileName)){
                repeatMap.put("repeatTimes",repeatTimes+1);
                repeatMap = checkRepeatFileName(originfileName, fileNames, repeatMap);
            }
        }
        return repeatMap;
    }
}
