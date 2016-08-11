package com.lijw.demo.test;

/**
 * Description
 * Created by lijianwei on 2016/8/11.
 */
public class CloneFactory {
    private static TestJavaBean testJavaBean = new TestJavaBean();

    public static TestJavaBean creatBean(){
        return (TestJavaBean)testJavaBean.clone();
    }
}
