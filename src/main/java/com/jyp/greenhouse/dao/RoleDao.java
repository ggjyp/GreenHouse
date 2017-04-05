package com.jyp.greenhouse.dao;

import com.jyp.greenhouse.pojo.Role;
import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017-04-04 13:38
 * Describe :
 */
public interface RoleDao {
    /**
     * 返回所有角色
     * @return
     */
    List<Role> listRoles();

    /**
     * 根据roleName返回相应的role对象
     * @param roleName
     * @return
     */
    Role getByRoleName(String roleName);
}
