package com.jyp.greenhouse.service;

import com.jyp.greenhouse.dto.PermissionDTO;
import com.jyp.greenhouse.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by jyp on 2017/3/7.
 */

public interface UserService {
    /**
     * 根据username和password进行用户登录
     * @param username
     * @param password
     * @return 登录成功返回相应User，否则返回null
     */
    User login(String username, String password);

    /**
     * 根据username获取user
     * @param username
     * @return
     */
    User getUserByName(String username);

    /**
     * 根据username获取该用户所有角色名
     * @param username
     * @return
     */
    Set<String> getRoles(String username) ;

    /**
     * 根据username获取该用户所有权限
     * @param username
     * @return
     */
    Set<String> getPermissions(String username) ;

    /**
     * 修改user
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 根据pageNumber和pageSize获取User列表
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<PermissionDTO> getUserPermissionList(int pageNumber, int pageSize);

    /**
     * 获取User总数
     * @return
     */
    int countAllUser();
}
