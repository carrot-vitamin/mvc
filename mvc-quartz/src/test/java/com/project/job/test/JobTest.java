package com.project.job.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yinshaobo on 2018/5/21
 */
public class JobTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/spring-quartz.xml");
        System.out.println("quartz start ok");
    }
}
