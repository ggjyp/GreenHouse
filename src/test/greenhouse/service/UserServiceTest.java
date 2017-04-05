package greenhouse.service;

import com.jyp.greenhouse.dto.PermissionDTO;
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
        List<PermissionDTO> userList = userService.getUserPermissionList((pageNumber-1)*pageSize, pageSize);
        for(PermissionDTO user:userList){
            System.out.println(user.toString());
        }
    }

    @Test
    public void testUpdateRoleId(){
        String username = "jyp";
        User user = userService.getUserByName(username);
        if (user.getRoleId() == 1)
            userService.updateRoleId(username,1);
        else
            userService.updateRoleId(username,3);

        System.out.println(userService.getUserByName(username).toString());
    }
}
