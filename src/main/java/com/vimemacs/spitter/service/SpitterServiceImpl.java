package com.vimemacs.spitter.service;

import com.vimemacs.spitter.domain.Spittle;
import com.vimemacs.spitter.persistence.SpitterDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by HWD on 2017/6/16.
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SpitterServiceImpl implements SpitterService {
    private SpitterDao spitterDao;

    private TransactionTemplate txTemplate;

//    public void saveSpittle(Spittle spittle) {
//        spitterDao.saveSpittle(spittle);
//    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void saveSpittle(final Spittle spittle) {
        txTemplate.execute(new TransactionCallback<Void>(){
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    spitterDao.saveSpittle(spittle);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }

    public SpitterDao getSpitterDao() {
        return spitterDao;
    }

    public void setSpitterDao(SpitterDao spitterDao) {
        this.spitterDao = spitterDao;
    }

    public TransactionTemplate getTxTemplate() {
        return txTemplate;
    }

    public void setTxTemplate(TransactionTemplate txTemplate) {
        this.txTemplate = txTemplate;
    }
}
