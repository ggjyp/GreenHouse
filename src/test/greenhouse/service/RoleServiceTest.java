package greenhouse.service;

import com.jyp.greenhouse.pojo.Role;
import com.jyp.greenhouse.service.RoleService;
import greenhouse.BaseTest;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;

/**
 * Author   : jyp
 * Date     : 2017-04-04 13:49
 * Describe :
 */
public class RoleServiceTest extends BaseTest{
    @Resource
    RoleService roleService;

    @Test
    public void testListRoles(){
        List<Role> roles = roleService.listRoles();
        for (Role role : roles) {
            System.out.println(role.toString());
        }
    }
}
