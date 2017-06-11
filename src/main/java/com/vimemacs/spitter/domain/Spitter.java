package com.vimemacs.spitter.domain;

import org.springframework.stereotype.Component;

/**
 * Created by HWD on 2017/6/10.
 */
@Component
public class Spitter {
    private Long id;

    private String username;

    private String password;

    private String fullname;

    private String email;

    private String update_by_email;
    private boolean updateByEmail;

    public Spitter() {
    }

    public Spitter(Long id, String username, String password, String fullname, String email, String update_by_email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.update_by_email = update_by_email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUpdate_by_email() {
        return update_by_email;
    }

    public void setUpdate_by_email(String update_by_email) {
        this.update_by_email = update_by_email;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }
}
