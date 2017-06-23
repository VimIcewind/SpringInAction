package com.vimemacs.spitter.persistence;

import com.vimemacs.spitter.domain.Spitter;
import com.vimemacs.spitter.domain.Spittle;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HWD on 2017/6/10.
 */
public class SimpleJdbcTemplateSpitterDao implements SpitterDao {
    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname, email, updateByEmail) values (?, ?, ?, ?, ?)";
    private static final String SQL_INSERT_SPITTER_PARAMS = "insert into spitter (username, password, fullname, email, updateByEmail) values (:username, :password, :fullname, :email, :updateByEmail)";
    private static final String SQL_UPDATE_SPITTER = "update spitter set username = ?, password = ?, fullname = ? where id = ?";
    private static final String SQL_SELECT_SPITTER = "select id, username, password, fullname from spitter where id = ?";

    private SimpleJdbcTemplate jdbcTemplate;

    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullname(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
        // spitter.setId(queryForIdentity());
    }

    public void addSpitterParams(Spitter spitter) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", spitter.getUsername());
        params.put("password", spitter.getPassword());
        params.put("fullname", spitter.getFullname());
        params.put("email", spitter.getEmail());
        params.put("updateByEmail", spitter.isUpdateByEmail());

        jdbcTemplate.update(SQL_INSERT_SPITTER, params);
        // spitter.setId(queryForIdentity());
    }

    public void saveSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_UPDATE_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullname(),
                spitter.getId());
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

    public Spitter getSpitterById(long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_SPITTER, new ParameterizedRowMapper<Spitter>() {
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

    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
