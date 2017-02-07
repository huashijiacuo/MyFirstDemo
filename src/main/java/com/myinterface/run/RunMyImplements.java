package com.myinterface.run;

import com.myinterface.implement.MyImplements;
import com.myinterface.interfaces.MyInterface;

/**
 * Created by shihuashun on 2016/12/9.
 */
public class RunMyImplements {
    private static MyInterface myInterface = new MyImplements();

    public static void main(String[] args){
        String name = myInterface.getName("Shi Huashun");
        System.out.println(name);
    }
}
