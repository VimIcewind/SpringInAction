package com.vimemacs.springidol;

/**
 * Created by HWD on 2017/5/24.
 */
public class SongSelector {
    private String song;

    public SongSelector() {
    }

    public SongSelector(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String selectSong() {
        return song;
    }
}
