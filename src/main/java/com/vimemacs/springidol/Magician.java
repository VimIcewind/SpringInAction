package com.vimemacs.springidol;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by HWD on 2017/5/31.
 */
@Component
@Aspect
public class Magician implements MindReader {
    private String thoughts;

    @Pointcut("execution(* com.vimemacs.springidol.Thinker.thinkOfSomething(String)) && args(thoughts)")
    public void thinking(String thoughts) {

    }

    @Before("thinking(thoughts)")
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
