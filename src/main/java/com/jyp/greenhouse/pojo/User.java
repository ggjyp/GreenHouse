package com.jyp.greenhouse.pojo;

/**
 * Author   : jyp
 * Date     : 2017/3/7 14:49
 * Describe :
 */
public class User {
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    private String username;
    private String password;
    private int roleId;

    public User() {
    }

    public User(String username, String password, int roleId) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
