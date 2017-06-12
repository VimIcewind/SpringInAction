package com.vimemacs.spitter.persistence;

import com.vimemacs.spitter.domain.Spitter;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * Created by HWD on 2017/6/10.
 */
public class JdbcSpitterDAO extends SimpleJdbcDaoSupport implements SpitterDAO {
    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname, email, update_by_email) values (?, ?, ?, ?, ?)";

    public void addSpitter(Spitter spitter) {
        getSimpleJdbcTemplate().update(SQL_INSERT_SPITTER,
        spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullname(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
        // spitter.setId(queryForIdentity());
    }
}
