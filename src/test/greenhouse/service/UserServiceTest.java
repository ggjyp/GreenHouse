package greenhouse.service;

import com.jyp.greenhouse.pojo.User;
import com.jyp.greenhouse.service.UserService;
import greenhouse.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/3/3 15:09
 * Describe :
 */
public class UserServiceTest extends BaseTest{
    @Resource
    UserService userService;

    @Test
    public void testLogin(){
        User user = userService.login("jyp","123456");
        System.out.println(user.toString());
    }
    @Test
    public void testListUser(){
        int pageNumber = 1;
        int pageSize = 10;
        List<User> userList = userService.getUserList((pageNumber-1)*pageSize, pageSize);
        for(User user:userList){
            System.out.println(user.toString());
        }
    }
}
