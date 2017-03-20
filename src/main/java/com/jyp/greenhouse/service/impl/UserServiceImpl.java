package com.jyp.greenhouse.service.impl;

import com.jyp.greenhouse.dao.UserDao;
import com.jyp.greenhouse.pojo.User;
import com.jyp.greenhouse.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by jyp on 2017/3/7.
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
}
