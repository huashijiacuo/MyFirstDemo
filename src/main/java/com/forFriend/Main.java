package com.forFriend;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shihuashun on 2016/12/28.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("开始构造URL");
        String ak = "Zv05UCwGyCWuub5VGuZBqLx70YIN2mKD";
        String url1 = "http://api.map.baidu.com/geocoder/v2/?address=";
        String url2 = "&output=json&ak=Zv05UCwGyCWuub5VGuZBqLx70YIN2mKD";

        String path = "D:" + File.separator + "forme.xlsx";
        DealExcel dealExcel = new DealExcel();
        List<MyMap> myMapList = new ArrayList<MyMap>();
        try{
            myMapList = dealExcel.readExcelFile(path);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(myMapList.size() > 0){
            int index = 0;
            for(MyMap myMap : myMapList){
                if(index < 1197){
                    index++;
                    continue;
                }
                if(index %399 == 0 ){
                    try{
                        Thread.sleep(5000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if(index %1211 == 0){
                        try{
                            Thread.sleep(10000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                String location = myMap.getAreaJ();
                String url = url1 + location + url2;
                //System.out.println(url);
                HttpRequestUtil httpRequestUtil = new HttpRequestUtil();
                String requestString = httpRequestUtil.HttpRequest(url);
                JSONObject jsonObj = new JSONObject(requestString);
                JSONObject locationtJson = jsonObj.getJSONObject("result").getJSONObject("location");
                String lng = locationtJson.get("lng").toString();
                String lat = locationtJson.get("lat").toString();
                System.out.println(++index +":" + location + "经度:" + lng + ", 纬度:" + lat);
            }
        }
        //StringBuffer sb = new StringBuffer();


        //上地十街返回结果,经度:116.30815063007148, 纬度:40.056890127931275
        //海淀区人民政府   经度:116.30456517028948, 纬度:39.966149129183336
    }
}
