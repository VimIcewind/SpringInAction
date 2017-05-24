package com.vimemacs.springidol;

import com.vimemacs.exception.PerformanceException;

import java.util.Collection;

/**
 * Created by HWD on 2017/5/24.
 */
public class OneManBand implements Performer {
    private Collection<Instrument> instruments;

    public OneManBand() {
    }

    public void perform() throws PerformanceException {
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }

    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    // 注入 instruments 集合
    public void setInstruments(Collection<Instrument> instruments) {
        this.instruments = instruments;
    }
}
