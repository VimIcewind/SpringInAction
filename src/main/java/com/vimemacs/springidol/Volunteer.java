package com.vimemacs.springidol;

import org.springframework.stereotype.Component;

/**
 * Created by HWD on 2017/5/31.
 */
@Component
public class Volunteer implements Thinker {
    private String thoughts;

    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
