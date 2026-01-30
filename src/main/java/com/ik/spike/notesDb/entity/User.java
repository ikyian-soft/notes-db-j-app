package com.ik.spike.notesDb.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="users")
public class User {

    @Id
    @Column(name = "username", unique = true, nullable = false, length=20)
    private String username;

    @Column(name = "password", nullable = false, length=100)
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserRight> userRights;

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<UserRight> getUserRights() {
        return userRights;
    }

    public void setUserRights(List<UserRight> userRights) {
        this.userRights = userRights;
    }
}
