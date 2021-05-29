package com.example.springboot;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JSONException, IOException {


        List<String> list =new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        System.out.println(list);
        File file = new File("./userinfo.txt");
//		Boolean flag =file.exists();
//		System.out.println(flag);
        //将list写入文件
        Writer out = new FileWriter(file);
        BufferedWriter bw= new BufferedWriter(out);
        for(String s:list) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        bw.close();

    }
}
