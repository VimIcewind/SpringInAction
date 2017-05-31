package com.vimemacs.springidol;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by HWD on 2017/5/31.
 */
public class MindReaderTest {
    @Test
    public void magicanShouldReadVolunteersMind() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Volunteer volunteer = (Volunteer) ctx.getBean("volunteer");
        Magician magician = (Magician) ctx.getBean("magician");
        volunteer.thinkOfSomething("Queen of Hearts");
        assertEquals("Queen of Hearts", magician.getThoughts());
    }
}
