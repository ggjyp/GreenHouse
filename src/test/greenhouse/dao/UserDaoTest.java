package greenhouse.dao;

import com.jyp.greenhouse.dao.UserDao;
import com.jyp.greenhouse.pojo.User;
import greenhouse.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by jyp on 2017/3/3.
 */

public class UserDaoTest extends BaseTest {
    @Resource
    UserDao userDao;

    @Test
    public void testGetById(){
        User user = userDao.getById(1);
        System.out.println(user.toString());
    }

    @Test
    public void testGetByName(){
        User user = userDao.getByName("jyp");
        System.out.println(user.toString());
    }

    @Test
    public void testListUser(){
        for (User user:userDao.getUserList(1,10)){
            System.out.println(user.toString());
        }
    }
}
