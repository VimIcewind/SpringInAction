package com.vimemacs.springidol;

import org.springframework.stereotype.Component;

/**
 * Created by HWD on 2017/5/31.
 */
@Component
public class Magician implements MindReader {
    private String thoughts;

    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
