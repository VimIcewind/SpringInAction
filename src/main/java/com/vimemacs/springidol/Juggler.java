package com.vimemacs.springidol;

import com.vimemacs.exception.PerformanceException;

/**
 * Created by HWD on 2017/5/22.
 */
public class Juggler implements Performer {
    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    public void perform() throws PerformanceException {
        System.out.println("JUGGLING " + beanBags + " BEANBAGS");
    }
}
