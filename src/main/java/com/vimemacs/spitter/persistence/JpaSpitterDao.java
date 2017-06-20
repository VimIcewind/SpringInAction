package com.vimemacs.spitter.persistence;

import com.vimemacs.spitter.domain.Spitter;
import com.vimemacs.spitter.domain.Spittle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by HWD on 2017/6/15.
 */
@Repository("spitterDao")
@Transactional
public class JpaSpitterDao implements SpitterDao{
    private static final String RECENT_SPITTLES = "SELECT s FROM Spittle s";
    private static final String ALL_SPITTERS = "SELECT s FROM Spitter s";
    private static final String SPITTER_FOR_USERNAME = "SELECT s FROM Spitter s WHERE s.username = :username";
    private static final String SPITTLES_BY_USERNAME = "SELECT s FROM Spittle s WHERE s.spitter.username = :username";

    @PersistenceContext
    private EntityManager em;

    public void addSpitter(Spitter spitter) {
        em.persist(spitter);
    }

    public Spitter getSpitterById(long id) {
        return em.find(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter) {
        em.merge(spitter);
    }

    public void saveSpittle(Spittle spittle) {

    }

    public List<Spittle> getRecentSpittle() {
        return null;
    }

    public Spitter getSpitterByUsername(String username) {
        return null;
    }

    public List<Spittle> getSpittlesByUsername(String username) {
        return null;
    }
}
