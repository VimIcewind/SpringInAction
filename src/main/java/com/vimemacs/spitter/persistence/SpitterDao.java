package com.vimemacs.spitter.persistence;

import com.vimemacs.spitter.domain.Spitter;
import com.vimemacs.spitter.domain.Spittle;

import java.util.List;

/**
 * Created by HWD on 2017/6/10.
 */
public interface SpitterDao {
    public void addSpitter(Spitter spitter);

    public Spitter getSpitterById(long id);

    public void saveSpitter(Spitter spitter);

    void saveSpittle(Spittle spittle);

    List<Spittle> getRecentSpittle();

    Spitter getSpitterByUsername(String username);

    List<Spittle> getSpittlesByUsername(String username);
}
