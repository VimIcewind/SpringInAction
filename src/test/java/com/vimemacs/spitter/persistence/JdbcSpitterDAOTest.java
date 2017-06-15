package com.vimemacs.spitter.persistence;

import com.vimemacs.spitter.domain.Spitter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HWD on 2017/6/10.
 */
public class JdbcSpitterDaoTest {
    @Test
    public void addSpitterTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-jdbc.xml");
        Spitter spitter = (Spitter) ctx.getBean("spitter");
        JdbcSpitterDao jdbcSpitterDao = (JdbcSpitterDao) ctx.getBean("spitterDao");
        jdbcSpitterDao.addSpitter(spitter);
    }
}
