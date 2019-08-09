package com.example.springboot;

import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws JSONException {


        JSONObject jsonObject = new JSONObject();
        JSONObject jsonData = jsonObject.getJSONObject("data");
        System.out.println(jsonData.toString());
    }
}
