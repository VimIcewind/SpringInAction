package com.vimemacs.springidol;

import com.vimemacs.exception.PerformanceException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HWD on 2017/5/24.
 */
public class OneManBandTest {
    @Test
    public void hank() throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("hank");
        performer.perform();
    }

    @Test
    public void hankmap() throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("hankmap");
        performer.perform();
    }

    @Test
    public void hankprop() throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("hankprop");
        performer.perform();
    }
}
