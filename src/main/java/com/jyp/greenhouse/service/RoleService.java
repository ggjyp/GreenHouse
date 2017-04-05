package com.jyp.greenhouse.service;

import com.jyp.greenhouse.pojo.Role;
import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017-04-04 13:42
 * Describe :
 */
public interface RoleService {
    /**
     * 返回所有角色名
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
