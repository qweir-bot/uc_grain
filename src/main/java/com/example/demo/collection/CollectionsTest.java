package com.example.demo.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsTest {

    /**
     * 定义一个线程安全的map
     */
    private Map<String,Object> map = Collections.synchronizedMap(new HashMap<>());
    /**
     * 通过ConcurrentHashMap 定义线程安全的map
     */
    private ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

}
