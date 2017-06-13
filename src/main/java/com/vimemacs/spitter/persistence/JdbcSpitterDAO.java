package com.vimemacs.spitter.persistence;

import com.vimemacs.spitter.domain.Spitter;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by HWD on 2017/6/10.
 */
public class JdbcSpitterDAO extends SimpleJdbcDaoSupport implements SpitterDAO {
    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname, email, update_by_email) values (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_SPITTER = "update spitter set username = ?, password = ?, fullname = ? where id = ?";
    private static final String SQL_SELECT_SPITTER = "select id, username, password, fullname from spitter where id = ?";

    private DataSource dataSource;

    public void addSpitter(Spitter spitter) {
        getSimpleJdbcTemplate().update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullname(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
        // spitter.setId(queryForIdentity());
    }

    public void saveSpitter(Spitter spitter) {
        getSimpleJdbcTemplate().update(SQL_UPDATE_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullname(),
                spitter.getId());
    }

    public Spitter getSpitterById(long id) {
        return getSimpleJdbcTemplate().queryForObject(SQL_SELECT_SPITTER, new ParameterizedRowMapper<Spitter>() {
                    public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Spitter spitter = new Spitter();
                        spitter.setId(rs.getLong(1));
                        spitter.setUsername(rs.getString(2));
                        spitter.setPassword(rs.getString(3));
                        spitter.setFullname(rs.getString(4));
                        return spitter;
                    }
                },
                id
        );
    }
}
