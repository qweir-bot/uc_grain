package com.example.demo.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.ibatis.parsing.GenericTokenParser;
import org.apache.ibatis.parsing.TokenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.*;

public class TableSplitUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableSplitUtils.class);

    private static final FastDateFormat FDT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    private TableSplitUtils() {

    }

    /**
     * 根据时间获取分表
     * @param content
     * @param date
     * @return
     */
    public static String getTable(String content, Date date) {
        String strategy = TableStrategy.TABLE_SPLITRULE.get(content);
        if (StringUtils.isEmpty(strategy)) {
            return content;
        }
        String tenantId = "";
        try {
            //获取当前请求的租户
            String curTenantId = "";
            //读取需要分表的租户ID
            Properties properties = new Properties();
            properties = PropertiesLoaderUtils.loadAllProperties("tenant/tenant.properties");
            //遍历取值
            Set<Object> objects = properties.keySet();
            Map<String,String> splitTenantMap = new HashMap<>();
            for (Object object : objects) {
                String key = (String) object;
                if(key != null && key.indexOf("splitTenant")>-1){
                    //如果当前请求的租户ID在需要分表的租户中，则给tenantId赋值并在表名中进行替换
                    if(curTenantId.equals(properties.getProperty(key))){
                        tenantId = "_" + curTenantId;
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("读取租户分表配置文件失败！");
        }
        final String splitTenantId = tenantId;
        final String tableName = content;

        GenericTokenParser tokenParser = new GenericTokenParser("{", "}", new TokenHandler() {
            @Override
            public String handleToken(String text) {
                if (StringUtils.isBlank(text)) {
                    return StringUtils.EMPTY;
                }
                if ("TABLE_NAME".equals(text)) {
                    return tableName;
                }
                if("TENANT_ID".equals(text)){
                    return splitTenantId;
                }
                String format = text;
                if (StringUtils.isNotBlank(format)) {
                    return FastDateFormat.getInstance(format).format(date);
                }
                return text;
            }
        });
        return tokenParser.parse(strategy);
    }

    /**
     * 根据工单流水获取分表
     * @param content
     * @param showSerildNo
     * @return
     */
    public static String getTable(String content, String showSerildNo) {
        String strategy = TableStrategy.TABLE_SPLITRULE.get(content);
        if (StringUtils.isEmpty(strategy)) {
            return content;
        }
        String tenantId = "";
        try {
            //获取当前请求的租户
            String curTenantId = "";
            //读取需要分表的租户ID
            Properties properties = new Properties();
            properties = PropertiesLoaderUtils.loadAllProperties("tenant/tenant.properties");
            //遍历取值
            Set<Object> objects = properties.keySet();
            Map<String,String> splitTenantMap = new HashMap<>();
            for (Object object : objects) {
                String key = (String) object;
                if(key != null && key.indexOf("splitTenant")>-1){
                    //如果当前请求的租户ID在需要分表的租户中，则给tenantId赋值并在表名中进行替换
                    if(curTenantId.equals(properties.getProperty(key))){
                        tenantId = "_" + curTenantId;
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("读取租户分表配置文件失败！");
        }
        final String splitTenantId = tenantId;
        final String tableName = content;
        GenericTokenParser tokenParser = new GenericTokenParser("{", "}", new TokenHandler() {
            @Override
            public String handleToken(String text) {
                if (StringUtils.isBlank(text)) {
                    return StringUtils.EMPTY;
                }
                if ("TABLE_NAME".equals(text)) {
                    return tableName;
                }
                if("TENANT_ID".equals(text)){
                    return splitTenantId;
                }
                String format = text;
                if (StringUtils.isNotBlank(format)) {
                    return showSerildNo.substring(0, format.length());
                }
                return text;
            }
        });
        return tokenParser.parse(strategy);
    }

    /**
     * 根据租户id获取分表
     * @param content
     * @return
     */
    public static String getTableByTenantId(String content) {
        String strategy = TableStrategy.ACTIVE_TABLE;
        if (StringUtils.isEmpty(strategy)) {
            return content;
        }
        String tenantId = "";
        try {
            //获取当前请求的租户
            String curTenantId = "";
            //读取需要分表的租户ID
            Properties properties = new Properties();
            properties = PropertiesLoaderUtils.loadAllProperties("tenant/tenant.properties");
            //遍历取值
            Set<Object> objects = properties.keySet();
            Map<String,String> splitTenantMap = new HashMap<>();
            for (Object object : objects) {
                String key = (String) object;
                if(key != null && key.indexOf("splitTenant")>-1){
                    //如果当前请求的租户ID在需要分表的租户中，则给tenantId赋值并在表名中进行替换
                    if(curTenantId.equals(properties.getProperty(key))){
                        tenantId = "_" + curTenantId;
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("读取租户分表配置文件失败！");
        }
        final String splitTenantId = tenantId;
        final String tableName = content;
        GenericTokenParser tokenParser = new GenericTokenParser("{", "}", new TokenHandler() {
            @Override
            public String handleToken(String text) {
                if (StringUtils.isBlank(text)) {
                    return StringUtils.EMPTY;
                }
                if ("TABLE_NAME".equals(text)) {
                    return tableName;
                }
                if("TENANT_ID".equals(text)){
                    return splitTenantId;
                }
                return text;
            }
        });
        return tokenParser.parse(strategy);
    }
}
