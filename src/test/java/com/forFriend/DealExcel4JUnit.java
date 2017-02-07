package com.forFriend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shihuashun on 2016/12/27.
 */
public class DealExcel4JUnit {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testWriteExcel() throws Exception {
        String path = "D:" + File.separator + "forme.xlsx";
        DealExcel dealExcel = new DealExcel();
        //dealExcel.createExcelFile();
        //dealExcel.writeExcelFile( path );
        List<MyMap> myMapList = dealExcel.readExcelFile(path);
        System.out.println("将Excel转化为MyMap对象");
        System.out.println(myMapList.size());
        for(MyMap myMap : myMapList){
            System.out.println(myMap);
        }
    }

    @Test
    public void testReadExcelFile() throws Exception {
        String path = "D:" + File.separator + "aa.xlsx";
        DealExcel dealExcel = new DealExcel();
        //dealExcel.createExcelFile();
        dealExcel.writeExcelFile( path );
        List<MyMap> myMapList = dealExcel.readExcelFile(path);
        System.out.println("将Excel转化为MyMap对象");
        System.out.println(myMapList.size());
        for(MyMap myMap : myMapList){
            System.out.println(myMap);
        }
    }
}