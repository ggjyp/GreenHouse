package greenhouse.service;

import com.jyp.greenhouse.pojo.User;
import com.jyp.greenhouse.service.UserService;
import greenhouse.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by jyp on 2017/3/3.
 */
public class UserServiceTest extends BaseTest{
    @Resource
    UserService userService;

    @Test
    public void testLogin(){
        User user = userService.login("jyp","123456");
        System.out.println(user.toString());
    }
}
