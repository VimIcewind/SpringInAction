package com.vimemacs.spitter.service;

import com.vimemacs.spitter.domain.Spitter;
import com.vimemacs.spitter.domain.Spittle;

import java.util.List;

/**
 * Created by HWD on 2017/6/16.
 */
public interface SpitterService {
    List<Spittle> getRecentSpittles(int count);

    Spitter getSpitter(String username);

    List<Spittle> getSpittlesForSpitter(String username);
}
