package com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by shihuashun on 2016/12/7.
 */
public class HelloWorld4TestNG {
    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testTestHelloWorld() throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.testHelloWorld();
        helloWorld.testHelloWorld1();
    }

    @Test
    public void testTestHelloWorld1() throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.testHelloWorld();
    }

}