package greenhouse.service;

import com.jyp.greenhouse.pojo.AutoControlParam;
import com.jyp.greenhouse.service.AutoControlParamService;
import com.jyp.greenhouse.util.CommonFunctions;
import greenhouse.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author   : jyp
 * Date     : 2017/4/7 10:01
 * Describe :
 */
public class ParamServiceTest extends BaseTest {
    @Resource
    AutoControlParamService autoControlParamService;

    @Test
    public void testUpdate() {
        AutoControlParam autoControlParam = autoControlParamService.getByParamName("新增测试");
        autoControlParam.setLightIntensityMax(15000);
        autoControlParam.setModifyDate(CommonFunctions.getCurrentDate());
        if (autoControlParamService.updateParam(autoControlParam)) {
            System.out.println(autoControlParamService.getByParamName("新增测试").toString());
        }
        else {
            System.out.println("修改失败");
        }
    }
}
