package com.vimemacs.springidol;

import com.vimemacs.exception.PerformanceException;

import java.util.Map;

/**
 * Created by HWD on 2017/5/24.
 */
public class OneManBandMap implements Performer {
    private Map<String, Instrument> instruments;

    public OneManBandMap() {
    }

    public void perform() throws PerformanceException {
        for (String key : instruments.keySet()) {
            Instrument instrument = instruments.get(key);
            instrument.play();
        }
    }

    public Map<String, Instrument> getInstruments() {
        return instruments;
    }

    // 以 Map 类型注入 instruments
    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }
}
