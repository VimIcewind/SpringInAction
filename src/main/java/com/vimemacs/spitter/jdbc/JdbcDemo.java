package com.vimemacs.spitter.jdbc;

import com.vimemacs.spitter.domain.Spitter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by HWD on 2017/6/10.
 */
public class JdbcDemo {
    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname) values (?, ?, ?)";
    private static final String SQL_UPDATE_SPITTER = "update spitter set username = ?, password = ?, fullname = ? where id = ?";
    private static final String SQL_SELECT_SPITTER = "select id, username, password, fullname from spitter where id = ?";

    private DataSource dataSource;

    public void addSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();
            System.out.println("conn = " + conn);

            stmt = conn.prepareStatement(SQL_INSERT_SPITTER);

            stmt.setString(1, spitter.getUsername());
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullname());

            stmt.execute();
        } catch (SQLException e) {
            System.out.println("SQLException");
            // do something... not sure what, though
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // I'm even less sure about what to do here
            }
        }
    }

    public void saveSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_SPITTER);

            stmt.setString(1, spitter.getUsername());
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullname());
            stmt.setLong(4, spitter.getId());

            stmt.execute();
        } catch (SQLException e) {
            System.out.println("SQLException");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQLException");
            }
        }

    }

    public Spitter getSpitterById(long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_SPITTER);

            stmt.setLong(1, id);

            rs = stmt.executeQuery();
            Spitter spitter = null;
            if (rs.next()) {
                spitter = new Spitter();
                spitter.setId(rs.getLong("id"));
                spitter.setUsername(rs.getString("username"));
                spitter.setUsername(rs.getString("password"));
                spitter.setUsername(rs.getString("fullname"));
            }
            return spitter;
        } catch (SQLException e) {
            System.out.println("SQLException");
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("SQLException");
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {

                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQLException");
                }
            }
        }
        return null;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
