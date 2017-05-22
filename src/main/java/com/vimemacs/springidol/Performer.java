package com.vimemacs.springidol;

import com.vimemacs.exception.PerformanceException;

/**
 * Created by HWD on 2017/5/22.
 */
public interface Performer {
    void perform() throws PerformanceException;
}
