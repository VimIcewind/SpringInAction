package com.vimemacs.springidol;

import com.vimemacs.exception.PerformanceException;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * Created by HWD on 2017/5/24.
 */
public class OneManBandProperties implements Performer {
    private Properties instruments;

    public OneManBandProperties() {
    }

    public void perform() throws PerformanceException {
        //System.out.println(instruments.values());
        Iterator<Entry<Object, Object>> it = instruments.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getValue());
        }
    }

    public Properties getInstruments() {
        return instruments;
    }

    public void setInstruments(Properties instruments) {
        this.instruments = instruments;
    }
}
