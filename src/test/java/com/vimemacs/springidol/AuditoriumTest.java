package com.vimemacs.springidol;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HWD on 2017/5/23.
 */
public class AuditoriumTest {
    @Test
    public void initMethod() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Auditorium auditorium = (Auditorium) ctx.getBean("auditorium");
    }
}
