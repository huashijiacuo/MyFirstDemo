package com;

import org.junit.Before;


/**
 * Created by shihuashun on 2016/12/7.
 */
public class HelloWorld4JUnit {
    @Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testHelloWorld() throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.testHelloWorld();
        helloWorld.testHelloWorld1();
    }

    @org.junit.Test
    public void testHelloWorld1() throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.testHelloWorld();
    }

}