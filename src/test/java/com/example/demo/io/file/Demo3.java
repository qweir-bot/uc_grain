package com.example.demo.io.file;

import java.io.File;
import java.io.IOException;

public class Demo3 {

    public static void main(String[] args){
        String parentPath = "E:/test/2.txt";
        File f1 = new File(parentPath);
        System.out.println(f1.exists());
        System.out.println(f1.isFile());
        System.out.println(f1.getName());
        System.out.println(f1.getPath());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getParent());
        System.out.println(f1.length());
        test3();
    }

    public static void test3(){
        String parentPath = "E:/test/3.txt";
        File f1 = new File(parentPath);
        if(f1.exists()){
            System.out.println(f1.length());
        }else {
            try {
                boolean newFile = f1.createNewFile();
                Thread.sleep(10000);
                f1.delete();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
