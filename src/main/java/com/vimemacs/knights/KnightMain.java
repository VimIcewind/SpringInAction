package com.vimemacs.knights;

import com.vimemacs.exception.QuestException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
    public static void main(String[] args) throws QuestException {
        // 加载 spring 上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/knights.xml");
        // 获取 knight Bean
        Knight knight = (Knight) context.getBean("knight");
        // 使用 knight
        knight.embarkOnQuest();
    }
}

