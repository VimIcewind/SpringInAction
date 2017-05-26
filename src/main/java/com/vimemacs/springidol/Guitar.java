package com.vimemacs.springidol;

import com.vimemacs.springidol.qualifiers.StringedInstrument;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by HWD on 2017/5/24.
 */
@StringedInstrument
public class Guitar implements Instrument {
    public Guitar() {
    }

    public void play() {
        System.out.println("STRUM STRUM STRUM");
    }
}
