package com.vimemacs.spitter.persistence;

import com.vimemacs.spitter.domain.Spitter;
import com.vimemacs.spitter.domain.Spittle;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by HWD on 2017/6/10.
 */
public class JdbcSpitterDao extends SimpleJdbcDaoSupport implements SpitterDao {
    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname, email, updateByEmail) values (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_SPITTER = "update spitter set username = ?, password = ?, fullname = ? where id = ?";
    private static final String SQL_SELECT_SPITTER = "select id, username, password, fullname from spitter where id = ?";
    private static final String SQL_SELECT_RECENT_SPITTLE = "select id, spitter_id, text, time from spittle where time > ?";
    private static final String SQL_SELECT_SPITTER_BY_USERNAME = "select min(id), username, password, fullname from spitter where username = ?";
    private static final String SQL_SELECT_SPITTLES_BY_USERNAME = "select le.id, spitter_id, text, time from spittle le, spitter er where le.spitter_id = er.id and er.username = ?";

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

    public void saveSpittle(Spittle spittle) {

    }

    public List<Spittle> getRecentSpittle() {
        DateTime dt = new DateTime().minusDays(30);
        return getSimpleJdbcTemplate().query(SQL_SELECT_RECENT_SPITTLE, new ParameterizedRowMapper<Spittle>() {
            public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
                Spittle spittle = new Spittle();
                spittle.setId(rs.getLong(1));
                spittle.setSpitter(getSpitterById(rs.getLong(2)));
                spittle.setText(rs.getString(3));
                spittle.setTime(rs.getDate(4));
                return spittle;
            }
        }, dt.toDate());
    }

    public Spitter getSpitterByUsername(String username) {
        return getSimpleJdbcTemplate().queryForObject(SQL_SELECT_SPITTER_BY_USERNAME, new ParameterizedRowMapper<Spitter>() {
                    public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Spitter spitter = new Spitter();
                        spitter.setId(rs.getLong(1));
                        spitter.setUsername(rs.getString(2));
                        spitter.setPassword(rs.getString(3));
                        spitter.setFullname(rs.getString(4));
                        return spitter;
                    }
                },
                username
        );
    }

    public List<Spittle> getSpittlesByUsername(String username) {
        return getSimpleJdbcTemplate().query(SQL_SELECT_SPITTLES_BY_USERNAME, new ParameterizedRowMapper<Spittle>() {
                    public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Spittle spittle = new Spittle();
                        spittle.setId(rs.getLong(1));
                        spittle.setSpitter(getSpitterById(rs.getLong(2)));
                        spittle.setText(rs.getString(3));
                        spittle.setTime(rs.getDate(4));
                        return spittle;
                    }
                },
                username
        );
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
