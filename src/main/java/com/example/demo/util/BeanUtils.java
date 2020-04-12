package com.example.demo.util;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

public class BeanUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanUtils.class);

    private BeanUtils() {

    }

    public static List<Map<String, Object>> beansToMap(List list) throws IllegalAccessException {
        List convertList = new ArrayList();
        for (Object object : list) {
            Map<String, Object> beanMap = BeanUtils.beanToMap(object);
            convertList.add(beanMap);
        }
        return convertList;
    }

    public static Map<String, Object> beanToMap(Object object) throws IllegalAccessException {
        Map<String, Object> beanMap = new HashMap<>();
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            beanMap.put(fieldName, field.get(object));
        }
        return beanMap;
    }

    public static <T> T mapToBean(Map<String, Object> map, T bean) throws Exception {
        Class<?> clazz = bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldNm = field.getName();
            if (StringUtils.isNotEmpty(MapUtils.getString(map, fieldNm))) {
                String typeNm =  field.getGenericType().getTypeName();
                Object value = null;
                switch (typeNm) {
                    case "java.lang.Byte" :{//java.lang.Byte
                        value = MapUtils.getByte(map, fieldNm);
                        break;
                    }
                    case "java.lang.Short" :{//java.lang.Short
                        value = MapUtils.getShort(map, fieldNm);
                        break;
                    }
                    case "java.lang.Integer" :{//java.lang.Integer
                        value = MapUtils.getInteger(map, fieldNm);
                        break;
                    }
                    case "java.lang.Long" :{//java.lang.Long
                        value = MapUtils.getLong(map, fieldNm);
                        break;
                    }
                    case "java.lang.String" :{//java.lang.String
                        value = MapUtils.getString(map, fieldNm);
                        break;
                    }
                    case "java.util.Date" :{//java.util.Date
                        if (map.get(fieldNm) instanceof Date) {
                            value = map.get(fieldNm);
                        } else if (map.get(fieldNm) instanceof Long){
                            value = new Date(MapUtils.getLongValue(map, fieldNm)) ;
                        } else {
                        	value = DateUtils.string2Date(MapUtils.getString(map, fieldNm));
                        }
                        break;
                    }
                    default: {

                    }
                }
                if (null == value) {
                    LOGGER.info("fieldNm:{},typeNm:{}", fieldNm, typeNm);
                    throw new Exception("转换失败");
                }
                field.set(bean, value);
            }
        }
        return bean;
    }
}
