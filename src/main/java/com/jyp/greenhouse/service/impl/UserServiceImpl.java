package com.jyp.greenhouse.service.impl;

import com.jyp.greenhouse.dao.UserDao;
import com.jyp.greenhouse.dto.PermissionDTO;
import com.jyp.greenhouse.pojo.User;
import com.jyp.greenhouse.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Author   : jyp
 * Date     : 2017/3/7 14:12
 * Describe :
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        User user = userDao.getByName(username);
        if(user != null){
            return user;
        }
        return null;
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getByName(username);
    }

    @Override
    public Set<String> getRoles(String username) {
        return userDao.getRoles(username);
    }

    @Override
    public Set<String> getPermissions(String username) {
        return userDao.getPermissions(username);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<PermissionDTO> getUserPermissionList(int pageNumber, int pageSize) {
        return userDao.getUserPermissionList(pageNumber, pageSize);
    }

    @Override
    public int countAllUser() {
        return userDao.countAllUser();
    }

}
