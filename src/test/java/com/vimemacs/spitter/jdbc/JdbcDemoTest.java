package com.vimemacs.spitter.jdbc;

import com.vimemacs.spitter.domain.Spitter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HWD on 2017/6/10.
 */
public class JdbcDemoTest {

    @Test
    public void addSpitterTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-jdbc.xml");
        Spitter spitter = (Spitter) ctx.getBean("spitter");
        JdbcDemo jdbcDemo = (JdbcDemo) ctx.getBean("jdbcDemo");
        jdbcDemo.addSpitter(spitter);
    }

    @Test
    public void saveSpitterTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-jdbc.xml");
        Spitter spitter = (Spitter) ctx.getBean("spitter");
        JdbcDemo jdbcDemo = (JdbcDemo) ctx.getBean("jdbcDemo");
        jdbcDemo.saveSpitter(spitter);
    }

    @Test
    public void getSpitterTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-jdbc.xml");
        JdbcDemo jdbcDemo = (JdbcDemo) ctx.getBean("jdbcDemo");
        Spitter spitter = jdbcDemo.getSpitterById(1);
    }
}
