package com.vimemacs.springidol;

import com.vimemacs.springidol.qualifiers.StringedInstrument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by HWD on 2017/5/24.
 */
@Component
public class Guitar implements Instrument {
    public Guitar() {
    }

    public void play() {
        System.out.println("STRUM STRUM STRUM");
    }
}
