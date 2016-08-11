package com.lijw.demo.test;

import java.util.Objects;

/**
 * Description
 * Created by lijianwei on 2016/8/11.
 */
public class TestJavaBean implements Cloneable {

    public void helloWorld(){
        System.out.print("test");
    }

    public Object clone(){
        TestJavaBean o = null;
        try {
            o = (TestJavaBean)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
