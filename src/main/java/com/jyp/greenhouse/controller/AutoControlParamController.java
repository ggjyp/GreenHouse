package com.jyp.greenhouse.controller;

import com.jyp.greenhouse.pojo.AutoControlParam;
import com.jyp.greenhouse.service.AutoControlParamService;
import com.jyp.greenhouse.util.CommonFunctions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jyp.greenhouse.util.StringUtil.FAILED;
import static com.jyp.greenhouse.util.StringUtil.SUCCESS;

/**
 * Author   : jyp
 * Date     : 2017/4/6 15:18
 * Describe : 自动控制参数控制器
 */
@Controller
@RequestMapping(value = "autoControlParam")
public class AutoControlParamController {
    @Resource
    AutoControlParamService autoControlParamService;

    @RequestMapping(value = "")
    public String toIndex() { return "auto_control_param_manager";}

    /**
     * 自控参数分页数据
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public HashMap<String,Object> listParams(int pageNumber, int pageSize){
        HashMap<String, Object> map = new HashMap<>();
        List<AutoControlParam> params = autoControlParamService.listParams((pageNumber-1)*pageSize,pageSize);
        int total = autoControlParamService.countAllParams();
        map.put("rows",params);
        map.put("total",total);
        return map;
    }

    @RequestMapping(value = "toAdd")
    public String toAdd() { return "add_auto_control_param";}

    /**
     * 增加自控参数
     * @param paramName
     * @param temperatureMin
     * @param temperatureMax
     * @param humidityMin
     * @param humidityMax
     * @param lightIntensityMin
     * @param lightIntensityMax
     * @param soilMoistureMin
     * @param soilMoistureMax
     * @return
     */
    @RequestMapping(value = "addParam")
    public String addParam(
            String paramName,
            float temperatureMin,
            float temperatureMax,
            float humidityMin,
            float humidityMax,
            float lightIntensityMin,
            float lightIntensityMax,
            float soilMoistureMin,
            float soilMoistureMax
    ) {
        AutoControlParam autoControlParam = new AutoControlParam();
        autoControlParam.setParamName(paramName);
        autoControlParam.setTemperatureMin(temperatureMin);
        autoControlParam.setTemperatureMax(temperatureMax);
        autoControlParam.setHumidityMin(humidityMin);
        autoControlParam.setHumidityMax(humidityMax);
        autoControlParam.setLightIntensityMin(lightIntensityMin);
        autoControlParam.setLightIntensityMax(lightIntensityMax);
        autoControlParam.setSoilMoistureMin(soilMoistureMin);
        autoControlParam.setSoilMoistureMax(soilMoistureMax);
        autoControlParam.setCreateDate(CommonFunctions.getCurrentDate());

        if (autoControlParamService.saveParamName(autoControlParam) == 1) {
            System.out.println("add_success");
            return "auto_control_param_manager";
        }
        else {
            System.out.println("add_failed");
            return null;
        }
    }

    /**
     * 删除自控参数
     * @param paramName
     * @return
     */
    @RequestMapping(value = "/deleteParam")
    @ResponseBody
    public HashMap<String,String> deleteParam(String paramName){
        HashMap<String,String> map = new HashMap<>();
        if (autoControlParamService.deleteParamByName(paramName)){
            map.put("result",SUCCESS);
        }
        else {
            map.put("result",FAILED);
        }
        return map;
    }

    //跳转至修改自控参数页面
    @RequestMapping(value = "/toEdit", method = RequestMethod.GET , produces = "text/plain;charset=UTF-8")
    public String toEdit(HttpServletRequest request, Model model){
        model.addAttribute("autoControlParam",autoControlParamService.getByParamName(request.getParameter("paramName")));
        return "modify_auto_control_param";
    }

    /**
     * 修改自控参数
     * @param paramName
     * @param temperatureMin
     * @param temperatureMax
     * @param humidityMin
     * @param humidityMax
     * @param lightIntensityMin
     * @param lightIntensityMax
     * @param soilMoistureMin
     * @param soilMoistureMax
     * @return
     */
    @RequestMapping(value = "modifyParam")
    public String modify(
            String paramName,
            float temperatureMin,
            float temperatureMax,
            float humidityMin,
            float humidityMax,
            float lightIntensityMin,
            float lightIntensityMax,
            float soilMoistureMin,
            float soilMoistureMax
    ) throws UnsupportedEncodingException {
        AutoControlParam autoControlParam = new AutoControlParam();
        autoControlParam.setParamName(paramName);
        autoControlParam.setTemperatureMin(temperatureMin);
        autoControlParam.setTemperatureMax(temperatureMax);
        autoControlParam.setHumidityMin(humidityMin);
        autoControlParam.setHumidityMax(humidityMax);
        autoControlParam.setLightIntensityMin(lightIntensityMin);
        autoControlParam.setLightIntensityMax(lightIntensityMax);
        autoControlParam.setSoilMoistureMin(soilMoistureMin);
        autoControlParam.setSoilMoistureMax(soilMoistureMax);
        autoControlParam.setModifyDate(CommonFunctions.getCurrentDate());
        if (autoControlParamService.updateParam(autoControlParam)) {
            System.out.println("success");
            return "auto_control_param_manager";
        }
        else {
            System.out.println("failed");
            return null;
        }
    }

    /**
     * 检测自控参数名称是否被注册
     * @param paramName
     * @return
     */
    @RequestMapping(value = "checkParamName")
    @ResponseBody
    public Map checkParamName(String paramName) {
        Map map = new HashMap();
        AutoControlParam autoControlParam = autoControlParamService.getByParamName(paramName);
        boolean flag = false;
        if(autoControlParam != null)
            flag = true;
        map.put("flag",flag);
        return map;
    }


}
