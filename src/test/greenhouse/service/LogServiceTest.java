package greenhouse.service;

import com.jyp.greenhouse.pojo.Log;
import com.jyp.greenhouse.service.LogService;
import greenhouse.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author   : jyp
 * Date     : 2017/4/6 10:07
 * Describe :
 */
public class LogServiceTest extends BaseTest {
    @Resource
    LogService logService;

    @Test
    public void testGetById(){
        System.out.println(logService.getById(1).toString());
    }

    @Test
    public void testListLogs(){
        int pageNumber = 0;
        int pageSize = 10;
        for (Log log:logService.listLogs(pageNumber,pageSize))
            System.out.println(log.toString());
    }

    @Test
    public void testCountAllLog(){
        System.out.println(logService.countAllLog());
    }
}
