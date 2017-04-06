package com.jyp.greenhouse.controller;

import com.jyp.greenhouse.pojo.Log;
import com.jyp.greenhouse.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.jyp.greenhouse.util.StringUtil.*;

/**
 * Author   : jyp
 * Date     : 2017/3/7 15:48
 * Describe : 日志控制器
 */
@Controller
@RequestMapping(value = "log")
public class LogController {
    @Resource
    LogService logService;

    @RequestMapping(value = "")
    public String toLogManager() { return "log_manager";}

    @RequestMapping(value = "/list")
    @ResponseBody
    public HashMap<String,Object> listLog(int pageNumber, int pageSize){
        HashMap<String,Object> map = new HashMap<>();
        List<Log> logs = logService.listLogs((pageNumber-1)*pageSize,pageSize);
        int total = logService.countAllLog();
        map.put("rows",logs);
        map.put("total",total);
        return map;
    }

    @RequestMapping(value = "/addLog")
    @ResponseBody
    public HashMap<String,String> addLog(
            String operateFrom,
            String operateTo,
            String behavior,
            int state
    ) {
        HashMap<String,String> map = new HashMap<>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Log log = new Log();
        log.setOperateFrom(operateFrom);
        log.setOperateTo(operateTo);
        log.setDate(df.format(new Date()));
        log.setBehavior(behavior);
        log.setState(state);

        if (logService.saveLog(log) == 1){
            map.put("result",SUCCESS);
        }
        else {
            map.put("result",FAILED);
        }
        return  map;

    }


}
