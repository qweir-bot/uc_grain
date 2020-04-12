package com.example.demo.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lijin on 2018/11/5.
 */
public class DSHJsonDateValueProcessor implements JsonValueProcessor {
    private String format ="yyyy-MM-dd HH:mm:ss";
    @Override
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value);
    }
    @Override
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    private Object process(Object value){
        if(value instanceof Date){
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(value);
        } else if (value instanceof Timestamp) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(value);
        }else if (value instanceof Long) {
            return value == null ? null : "" + value;
        }
        return value == null ? "" : value.toString();
    }

}
