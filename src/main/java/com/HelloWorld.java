package com;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by shihuashun on 2016/11/25.
 */
public class HelloWorld {

    public void testHelloWorld() {
        System.out.println("Hello World");
    }

    public void testHelloWorld1() {
        System.out.println("Hello World1");
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("aaaaa");
        String str = list.get(0);
        System.out.println(str);
        /*String s = null;
        if("ss".equals(s)){
            System.out.println("s is ss");
        } else {
            System.out.println("sss");
        }*/
       /* String userHtbIds = "1,2,3,4,5,6,7,7";
        String[] htbUserIds = userHtbIds.split(",");
        Set<String> htbUserIdSet = new HashSet<String>(Arrays.asList(htbUserIds));
        if(htbUserIdSet.size() != htbUserIds.length){
            System.out.println("有重复！");
        } else {
            System.out.println("没有重复");
        }*/
        Date time = new Date();
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("yyyy-MM-dd");
        String ctime = formatter.format(time);
        System.out.println(ctime);
    }

    /**
     * Created by shihuashun on 2016/12/7.
     */
    public static class JDBCTest {
    }
}