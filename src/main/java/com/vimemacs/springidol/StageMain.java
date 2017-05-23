package com.vimemacs.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HWD on 2017/5/23.
 */
public class StageMain {
    public static void main(String[] args) {
        System.out.println(Stage.getInstance());

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-idol.xml");
        Stage stage = (Stage) ctx.getBean("theStage");
        System.out.println(stage.getInstance());

        System.out.println(Stage.getInstance());
    }
}
