package com.example.demo.io.buffer;

import java.io.*;

public class Demo5 {

    public static void main(String[] args){
        File file = new File("E:/test/3.txt");
        try {
            //字节读取
            FileInputStream in = new FileInputStream(file);
            //进行缓冲
            BufferedInputStream bin = new BufferedInputStream(in);

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            BufferedWriter bw = new BufferedWriter(new FileWriter("E:/test/3.txt"));
            while (null != (line = br.readLine())){
                bw.write(line);
                bw.newLine();
            }
            bw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
