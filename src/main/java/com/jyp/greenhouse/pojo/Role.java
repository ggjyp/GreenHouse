package com.jyp.greenhouse.pojo;

/**
 * Author   : jyp
 * Date     : 2017-04-04 13:36
 * Describe :
 */
public class Role {
    private int roleId;
    private String roleName;
    private String roleSign;


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public String getRoleSign() {
        return roleSign;
    }


    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }


    public Role() {
    }


    public Role(int roleId, String roleName, String roleSign) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleSign = roleSign;
    }


    @Override public String toString() {
        return "Role{" +
            "roleId=" + roleId +
            ", roleName='" + roleName + '\'' +
            ", roleSign='" + roleSign + '\'' +
            '}';
    }
}
