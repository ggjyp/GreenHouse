package com.jyp.greenhouse.dto;

/**
 * Author   : jyp
 * Date     : 2017-04-04 11:44
 * Describe :
 */
public class PermissionDTO {
    private String username;
    private String roleName;


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getRoleName() {
        return roleName;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public PermissionDTO() {
    }


    public PermissionDTO(String username, String roleName) {
        this.username = username;
        this.roleName = roleName;
    }


    @Override public String toString() {
        return "PermissionDTO{" +
            "username='" + username + '\'' +
            ", roleName='" + roleName + '\'' +
            '}';
    }
}
