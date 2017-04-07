package greenhouse.dao;

import com.jyp.greenhouse.dao.AutoControlParamDao;
import com.jyp.greenhouse.pojo.AutoControlParam;
import greenhouse.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author   : jyp
 * Date     : 2017/4/6 14:52
 * Describe :
 */
public class AutoControlParamTest extends BaseTest {
    @Resource
    AutoControlParamDao autoControlParamDao;

    @Test
    public void testGetByParamName(){
        System.out.println(autoControlParamDao.getByParamName("蝴蝶兰开花期").toString());
    }

    @Test
    public void testSave(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        AutoControlParam autoControlParam = autoControlParamDao.getByParamName("蝴蝶兰开花期");
        autoControlParam.setParamName("新增测试");
        autoControlParam.setCreateDate(df.format(new Date()));
        if (autoControlParamDao.saveParamName(autoControlParam) == 1) {
            System.out.println(autoControlParamDao.getByParamName("新增测试").toString());
        }
        else {
            System.out.println("新增失败");
        }

    }

    @Test
    public void testUpdate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        AutoControlParam autoControlParam = autoControlParamDao.getByParamName("新增测试");
        autoControlParam.setLightIntensityMax(15000);
        autoControlParam.setModifyDate(df.format(new Date()));
        if (autoControlParamDao.updateParam(autoControlParam)) {
            System.out.println(autoControlParamDao.getByParamName("新增测试").toString());
        }
        else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void delete(){
        if (autoControlParamDao.deleteParamByName("新增测试")) {
            System.out.println(autoControlParamDao.getByParamName("新增测试").toString());
        }
        else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void listParams(){
        for (AutoControlParam autoControlParam : autoControlParamDao.listParams(0,10)) {
            System.out.println(autoControlParam.toString());
        }
    }

    @Test
    public  void count(){
        System.out.println(autoControlParamDao.countAllParams());
    }
}
