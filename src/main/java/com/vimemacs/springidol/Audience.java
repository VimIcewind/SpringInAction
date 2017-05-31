package com.vimemacs.springidol;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by HWD on 2017/5/31.
 */
public class Audience {
    // 表演之前
    public void takeSeats() {
        System.out.println("The audience is taking their seats.");
    }

    // 表演之前
    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cellphones");
    }

    // AOP 环绕通知
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
    public void applaud() {
        System.out.println("CLAP CLAP CLAP ClAP CLAP");
    }

    // 表演失败之后
    public void demandRefund() {
        System.out.println("Boo! We want our money back!");
    }
}
