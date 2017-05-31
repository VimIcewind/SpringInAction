package com.vimemacs.springidol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by HWD on 2017/5/31.
 */
@Component
@Aspect
public class Audience {
    //定义切点
    @Pointcut("execution(* com.vimemacs.springidol.Performer.perform(..))")
    public void performance() {
    }

    // 表演之前
    @Before("performance()")
    public void takeSeats() {
        System.out.println("The audience is taking their seats.");
    }

    // 表演之前
    @Before("performance()")
    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cellphones");
    }

    // AOP 环绕通知
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            // 表演之前
            System.out.println("The audience is taking their seats.");
            System.out.println("The audience is turing off their cellphones");
            long start = System.currentTimeMillis();

            // 执行被通知的方法
            joinPoint.proceed();

            // 表演之后
            long end = System.currentTimeMillis();
            System.out.println("CLAP CLAP CLAP CLAP CLAP");
            System.out.println("The performance took " + (end - start) + " milliseconds.");
        } catch (Throwable t) {
            System.out.println("Boo! We want our money back!");
        }
    }

    // 表演之后
    @AfterReturning("performance()")
    public void applaud() {
        System.out.println("CLAP CLAP CLAP ClAP CLAP");
    }

    // 表演失败之后
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Boo! We want our money back!");
    }
}
