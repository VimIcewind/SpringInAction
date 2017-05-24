package com.vimemacs.springidol;

import com.vimemacs.exception.PerformanceException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HWD on 2017/5/24.
 */
public class InstrumentalistTest {
    @Test
    public void kenny() throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("kenny");
        performer.perform();
    }
}