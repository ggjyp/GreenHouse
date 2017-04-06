package greenhouse.dao;

import com.jyp.greenhouse.dao.LogDao;
import com.jyp.greenhouse.pojo.Log;
import greenhouse.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author   : jyp
 * Date     : 2017/4/5 17:07
 * Describe :
 */
public class LogDaoTest extends BaseTest {
    @Resource
    LogDao logDao;

    @Test
    public void testSaveLog(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Log log = new Log();
        log.setOperateFrom("jyp");
        log.setOperateTo("LED");
        log.setDate(df.format(new Date()));
        log.setBehavior("close");
        log.setState(1);
        logDao.saveLog(log);
    }

    @Test
    public void testGetById(){
        System.out.println(logDao.getById(1).toString());
    }

    @Test
    public void testListLogs(){
        int pageNumber = 0;
        int pageSize = 10;
        for (Log log:logDao.listLogs(pageNumber,pageSize))
            System.out.println(log.toString());
    }

    @Test
    public void testCountAllLog(){
        System.out.println(logDao.countAllLog());
    }
}
