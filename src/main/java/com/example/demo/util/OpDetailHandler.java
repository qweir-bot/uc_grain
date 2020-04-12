package com.example.demo.util;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpDetailHandler {

    private static final Logger logger = LoggerFactory.getLogger(OpDetailHandler.class);

    private static Element root;

    private static final String  SUCCESS_CODE = "00000";

    private static final String FAIL_CODE = "-9999";

    private static final String DEFAULT_DATA_FORMAT = "yyyy-MM-dd HH:mm:ss";

    static {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("fieldtransferxml/op-detail.xml");
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(in);
        } catch (DocumentException e) {
            logger.error("解析op-detail.xml失败！", e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        root = doc.getRootElement();
    }

    private OpDetailHandler() {

    }

    /**
     * 内外参数转换
     * @param invokType  转换方向
     * @param fieldId
     * @param param
     * @return
     */
    public static Map<String, Object> parseMap(String invokType, String fieldId, Map<String, Object> param){
        logger.info("解析opDetail fieldId = {}", fieldId);
        Map<String, Object> convertMap = new HashedMap();
        if(StringUtils.isEmpty(fieldId) || param == null || param.isEmpty()){
            return convertMap;
        }
        Element filed = root.elementByID(fieldId);
        List list = filed.elements();
        String localNm;
        String remoteNm;
        String paramType;
        String defaultVal;
        for(int i = 0; i < list.size(); i++) {
            Element e = (Element) list.get(i);
            localNm = e.attributeValue("localNm");
            remoteNm = e.attributeValue("remoteNm");
            paramType = e.attributeValue("paramType");
            defaultVal = e.attributeValue("default");
            if (StringUtils.isNotEmpty(localNm) && StringUtils.isNotEmpty(remoteNm)) {
                String valueKey;
                if (StringUtils.equals(Constants.INVOK_TYPE_IN, invokType)) {
                    valueKey = remoteNm;
                } else {
                    valueKey = localNm;
                }
                Object value = param.get(valueKey);
                if (value instanceof String && StringUtils.isEmpty((String)value)) {
                    value = defaultVal;
                }
                if ("datatime".equals(paramType)) {
                    String dataFormt = e.attributeValue("dataFormt");
                    if (StringUtils.equals(Constants.INVOK_TYPE_IN, invokType)) {
                        if (value instanceof String && StringUtils.isNotEmpty((String)value)) {
                            value = DateUtils.stringToDate((String)value, StringUtils.isEmpty(dataFormt)?
                                    DEFAULT_DATA_FORMAT : dataFormt);
                        }
                    } else {
                        if (value instanceof Date && null != value) {
                            value = DateUtils.date2String((Date)value, DEFAULT_DATA_FORMAT);
                        }
                    }
                }
                if (StringUtils.equals(Constants.INVOK_TYPE_IN, invokType)) {
                    convertMap.put(localNm, value);
                } else {
                    convertMap.put(remoteNm, value);
                }
            }
        }
        return convertMap;
    }

    /**
     * 失败响应
     * @param respDesc
     * @return
     */
    public static Map<String, Object> failRsp(String respDesc) {
        if (StringUtils.isEmpty(respDesc)) {
            respDesc = "失败";
        }
        Map<String, Object> fail = new HashMap<>();
        fail.put("respCode", FAIL_CODE);
        fail.put("respDesc", respDesc);
        fail.put("result", false);
        return fail;
    }

    /**
     * 成功响应
     * @param
     * @return
     */
    public static Map<String, Object> successRsp(String respDesc) {
        if (StringUtils.isEmpty(respDesc)) {
            respDesc = "成功";
        }
        Map<String, Object> success = new HashMap<>();
        success.put("respCode", SUCCESS_CODE);
        success.put("respDesc", respDesc);
        success.put("result", true);
        return success;
    }

    /**
     * 成功响应
     * @param respDesc
     * @param result
     * @return
     */
    public static Map<String, Object> successRsp(String respDesc, Map<String, Object> result) {
        if (StringUtils.isEmpty(respDesc)) {
            respDesc = "成功";
        }
        Map<String, Object> success = new HashMap<>();
        success.put("respCode", SUCCESS_CODE);
        success.put("respDesc", respDesc);
        if (result.containsKey("result")) {
            success.put("result", result.get("result"));
        } else {
            success.put("result", true);
        }
        return success;
    }

}
