package com.vimemacs.spitter.domain;

import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by HWD on 2017/6/16.
 */
@Component
public class Spittle {
    private long id;
    private Spitter spitter;
    private String text;
    private Date time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
