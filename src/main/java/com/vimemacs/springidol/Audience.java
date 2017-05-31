package com.vimemacs.springidol;

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

    // 表演之后
    public void applaud() {
        System.out.println("CLAP CLAP CLAP ClAP CLAP");
    }

    // 表演失败之后
    public void demandRefund() {
        System.out.println("Boo! We want our money back!");
    }
}
