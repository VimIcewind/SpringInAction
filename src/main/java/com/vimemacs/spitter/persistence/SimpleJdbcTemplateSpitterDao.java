package com.vimemacs.spitter.persistence;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * Created by HWD on 2017/6/10.
 */
public class SimpleJdbcTemplateSpitterDao implements SpitterDAO {
    private SimpleJdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
