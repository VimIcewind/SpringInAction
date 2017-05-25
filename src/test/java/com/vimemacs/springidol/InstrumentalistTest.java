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

    @Test
    public void kennyp() throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("kennyp");
        performer.perform();
    }

    @Test
    public void kennyAutowiringByName() throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("kennyAutowiringByName");
        performer.perform();
    }

    @Test
    public void kennyAutowiringByType() throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("kennyAutowiringByType");
        performer.perform();
    }

    @Test
    public void carl() throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("carl");
        performer.perform();
    }
}
