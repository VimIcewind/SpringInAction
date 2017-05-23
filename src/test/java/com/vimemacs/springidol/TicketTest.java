package com.vimemacs.springidol;

import org.junit.Test;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HWD on 2017/5/23.
 */
public class TicketTest {
    @Test
    public void prototype() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Ticket ticket = (Ticket) ctx.getBean("ticket");
        System.out.println(ticket);
        Ticket ticket1 = (Ticket) ctx.getBean("ticket");
        System.out.println(ticket1);

        ApplicationContext ctx1 = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Ticket ticket2 = (Ticket) ctx1.getBean("ticket1");
        System.out.println(ticket2);
        Ticket ticket3 = (Ticket) ctx1.getBean("ticket1");
        System.out.println(ticket3);
    }
}
