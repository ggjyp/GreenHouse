package greenhouse.dao;

import com.jyp.greenhouse.dao.RoleDao;
import com.jyp.greenhouse.dao.UserDao;
import com.jyp.greenhouse.dto.PermissionDTO;
import com.jyp.greenhouse.pojo.Role;
import com.jyp.greenhouse.pojo.User;
import greenhouse.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;


public class RoleDaoTest extends BaseTest {
    @Resource
    RoleDao roleDao;
    @Test
    public void testListRoleName(){
        for (Role role:roleDao.listRoles()){
            System.out.println(role.toString());
        }
    }
}
