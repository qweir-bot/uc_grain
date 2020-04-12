package com.example.demo.util;

import com.example.demo.annotation.NeedSetValue;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class BeanUtil implements ApplicationContextAware {

    private  ApplicationContext applicationContext;

    public  void setFiledValueForCol(Collection col) throws  Exception{//封装，利用反射机制

        //获取注解--method名字
        //method.invoke()--user 对象-- 获取里面的userName属性--set到结果集中
        Class<?> clazz = col.iterator().next().getClass();
        Field[] fields = clazz.getDeclaredFields();
        Map<String,Object> cache = new HashMap<>();

        for (Field needField:fields) {
            NeedSetValue sv = needField.getAnnotation(NeedSetValue.class);
            if(sv == null){
                continue;
            }
            needField.setAccessible(true);//设为可见
            Object bean = this.applicationContext.getBean(sv.beanClass());
            Method method = sv.beanClass().getMethod(sv.method(),clazz.getDeclaredField(sv.param()).getType());
            Field paramField = clazz.getDeclaredField(sv.param());
            paramField.setAccessible(true);

            Field targetField = null;
            boolean needInnerField = !StringUtils.isEmpty(sv.targetFiled());
            String keyPrefix = sv.beanClass()+"-"+sv.method()+"-"+sv.targetFiled()+"-";

            for (Object obj: col) {
                Object paramVale = paramField.get(obj);//入参的具体值
                if (paramField == null){
                    continue;
                }
                Object value = null;
                String key = keyPrefix;
                if (cache.containsKey(key)){
                    value = cache.get(key);
                }else {

                    value = method.invoke(bean,paramVale);
                    if(needInnerField){

                        if(value != null){
                            if(targetField == null){
                                targetField = value.getClass().getDeclaredField(sv.targetFiled());
                                targetField.setAccessible(true);
                            }
                            value = targetField.get(value);
                        }
                    }
                    cache.put(key,value);
                }
                needField.set(obj,value);//把name set 进去
            }

        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
