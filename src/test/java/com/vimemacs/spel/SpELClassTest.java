package com.vimemacs.spel;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HWD on 2017/5/24.
 */
public class SpELClassTest {
    @Test
    public void spelclass() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/math.xml");
        SpELClass spELClass = (SpELClass) ctx.getBean("spelclass");
        System.out.println(spELClass.getMultiplier());
        System.out.println(spELClass.getRandomNumber());
    }
}
