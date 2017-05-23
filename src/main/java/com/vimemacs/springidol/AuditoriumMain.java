package com.vimemacs.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HWD on 2017/5/23.
 */
public class AuditoriumMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Auditorium auditorium = (Auditorium) ctx.getBean("auditorium");
    }
}
