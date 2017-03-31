package com.jyp.greenhouse.dao;

import com.jyp.greenhouse.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Author   : jyp
 * Date     : 2017/3/7 14:51
 * Describe :
 */
@Service(value = "userDao")
public interface UserDao {
    /**
     * 根据id获取User
     * @param id
     * @return
     */
    User getById(int id);

    /**
     * 根据username获取User
     * @param username
     * @return
     */
    User getByName(String username);

    /**
     * 根据username获取role_name
     * @param username
     * @return
     */
    Set<String> getRoles(String username);

    /**
     * 根据username获取Permission_name
     * @param username
     * @return
     */
    Set<String> getPermissions(String username);

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
    List<User> getUserList(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize);

    /**
     * 获取User总数
     * @return
     */
    int countAllUser();

}
