package com.vimemacs.springidol;

/**
 * Created by HWD on 2017/5/31.
 */
public interface MindReader {
    void interceptThoughts(String thoughts);

    String getThoughts();
}
