package com.example.demo.util;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.parsing.GenericTokenParser;
import org.apache.ibatis.parsing.TokenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class SmsUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsUtils.class);

    private SmsUtils() {

    }

    /**
     * 替换模板变量
     * @param params
     * @param template
     * @return
     */
    public static String replaceSmsTemplate(Map<String, Object> params, String template) {
        if (MapUtils.isEmpty(params) || StringUtils.isEmpty(template)) {
            return "";
        }
        GenericTokenParser tokenParser = new GenericTokenParser("!{", "}", new TokenHandler() {
            @Override
            public String handleToken(String text) {
                if (StringUtils.isBlank(text)) {
                    return StringUtils.EMPTY;
                }
                return MapUtils.getString(params, text, StringUtils.EMPTY);
            }
        });
        return tokenParser.parse(template);
    }

    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", "工单主题");
        params.put("total", "21");
        String template = "超时通知：[互联网化帮助台]任务775195标题:【催】!{title}-!{complainPhone}，状态:帮助台处理，已经超时，请尽快处理。";
        template = replaceSmsTemplate(params, template);
        LOGGER.info("::::::|" + template);
    }

}