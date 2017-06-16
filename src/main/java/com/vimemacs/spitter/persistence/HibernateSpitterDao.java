package com.vimemacs.spitter.persistence;

import com.vimemacs.spitter.domain.Spitter;
import com.vimemacs.spitter.domain.Spittle;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by HWD on 2017/6/15.
 */
@Repository
public class HibernateSpitterDao implements SpitterDao {
    private SessionFactory sessionFactory;

    // 构造DAO
    @Autowired
    public HibernateSpitterDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // 从 SessionFactory 中获取当前的 Session
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    // 使用当前 Session
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    public Spitter getSpitterById(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter) {
        currentSession().update(spitter);
    }

    public void saveSpittle(Spittle spittle) {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
