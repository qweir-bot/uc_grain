package com.example.demo.io.file;

import org.apache.kafka.common.protocol.types.Field;

import java.io.File;

public class Demo2 {

    public static void main(String[] args){
        String parentPath = "E:/test";
        String name = "2.jpg";
        File f1 = new File(parentPath,name);
        System.out.println(f1.getName());
        System.out.println(f1.getPath());
        File f2 = new File(name);
        System.out.println(f2.getName());
        System.out.println(f2.getPath());
        System.out.println(f2.getAbsolutePath());




    }
}
