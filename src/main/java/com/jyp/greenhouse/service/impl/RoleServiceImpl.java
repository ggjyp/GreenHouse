package com.jyp.greenhouse.service.impl;

import com.jyp.greenhouse.dao.RoleDao;
import com.jyp.greenhouse.pojo.Role;
import com.jyp.greenhouse.service.RoleService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Author   : jyp
 * Date     : 2017-04-04 13:43
 * Describe :
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Resource
    RoleDao roleDao;


    @Override public List<Role> listRoles() {
        return roleDao.listRoles();
    }


    @Override public Role getByRoleName(String roleName) {
        return roleDao.getByRoleName(roleName);
    }
}
