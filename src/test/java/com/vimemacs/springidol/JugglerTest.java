package com.vimemacs.springidol;

import com.vimemacs.exception.PerformanceException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HWD on 2017/5/22.
 */
public class JugglerTest {
    @Test
    public void perform() throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("duke");
        performer.perform();
        System.out.println();

        performer = (Performer) ctx.getBean("poeticDuke");
        performer.perform();
        System.out.println();

        System.out.println("constructor");
        performer = (Performer) ctx.getBean("dukeConstructor");
        performer.perform();
        System.out.println();

        System.out.println("autodetect");
        performer = (Performer) ctx.getBean("dukeAutodetect");
        performer.perform();
        System.out.println();
    }
}
