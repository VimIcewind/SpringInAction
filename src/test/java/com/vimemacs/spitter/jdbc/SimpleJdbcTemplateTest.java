package com.vimemacs.spitter.jdbc;

import com.vimemacs.spitter.domain.Spitter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * Created by HWD on 2017/6/10.
 */
public class SimpleJdbcTemplateTest {
    @Test
    public void addSpitterTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-jdbc.xml");
        Spitter spitter = (Spitter) ctx.getBean("spitter");
        SimpleJdbcTemplateDemo simpleJdbcTemplateDemo = (SimpleJdbcTemplateDemo) ctx.getBean("simpleJdbcTemplateDemo");
        simpleJdbcTemplateDemo.addSpitter(spitter);
    }

    @Test
    public void addSpitterParamsTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-jdbc.xml");
        Spitter spitter = (Spitter) ctx.getBean("spitter");
        SimpleJdbcTemplateDemo simpleJdbcTemplateDemo = (SimpleJdbcTemplateDemo) ctx.getBean("simpleJdbcTemplateDemo");
        simpleJdbcTemplateDemo.addSpitter(spitter);
    }

    @Test
    public void saveSpitterTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-jdbc.xml");
        Spitter spitter = (Spitter) ctx.getBean("spitter");
        SimpleJdbcTemplateDemo simpleJdbcTemplateDemo = (SimpleJdbcTemplateDemo) ctx.getBean("simpleJdbcTemplateDemo");
        simpleJdbcTemplateDemo.saveSpitter(spitter);
    }

    @Test
    public void getSpitterTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-jdbc.xml");
        SimpleJdbcTemplateDemo simpleJdbcTemplateDemo = (SimpleJdbcTemplateDemo) ctx.getBean("simpleJdbcTemplateDemo");
        Spitter spitter = simpleJdbcTemplateDemo.getSpitterById(1);
    }
}
