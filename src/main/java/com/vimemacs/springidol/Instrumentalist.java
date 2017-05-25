package com.vimemacs.springidol;

import com.vimemacs.exception.PerformanceException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by HWD on 2017/5/23.
 */
public class Instrumentalist implements Performer {
    int age;
    private String song;
    @Autowired
    private Instrument instrument;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSong() {
        return song;
    }

    public String screamSong() {
        return song;
    }

    // 注入歌曲
    public void setSong(String song) {
        this.song = song;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    // 注入乐器
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Instrumentalist() {
    }

    public void perform() throws PerformanceException {
        System.out.print("Playing " + song + " : ");
        instrument.play();
    }
}
