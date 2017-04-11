package com.jyp.greenhouse.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jyp.greenhouse.pojo.Measurement;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Author   : jyp
 * Date     : 2017/3/7 16:23
 * Describe : 访问SireWhere的RESTFUL接口
 */
@Controller
@RequestMapping(value = "sitewhere")
public class SiteWhereController {

     @RequestMapping(value = "")
     public String toSiteWhere() {
         return "measurements_show";
     }

    @RequestMapping(value = "/measurements")
    public String getAssignmentsMeasurements(String page, String pageSize, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        PrintWriter pw = response.getWriter();
        String assignmentToken  = "83d43843-c4a7-403c-83ac-9dc0d1918aba";
               String parameters = "?page="+ page +"&pageSize="+pageSize;
        String uri = "http://localhost:8080/sitewhere/api/assignments/"
            + assignmentToken + "/measurements" + parameters;

        JSONObject jsonObject = getHtmlJsonByUrl(uri );
        int total = (Integer)jsonObject.get("numResults");
        List<Measurement> measurements = new ArrayList<>();

        JSONArray results = jsonObject.getJSONArray("results");
        JSONObject result;
        JSONObject measurementObj;
        //循环次数超过10次就不能继续
        for (int i = 0; i < results.size(); i++){
            result = results.getJSONObject(i);
            measurementObj = result.getJSONObject("measurements");
            double temperature = Double.valueOf(measurementObj.get("temperature").toString());
            double humidity = Double.valueOf(measurementObj.get("humidity").toString());
            String eventDate = result.get("eventDate").toString();
            System.out.println(temperature);
            System.out.println(humidity);
            System.out.println(eventDate);
            Measurement measurement = new Measurement(temperature,humidity,eventDate);
            measurements.add(measurement);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", measurements);
        String json = JSONObject.toJSONString(map);
        pw.print(json);
        return null;

    }


    /**
     * 访问urlTemp并获取JSON对象
     * @param urlTemp
     * @return
     */
    private static JSONObject getHtmlJsonByUrl(String urlTemp){
        URL url = null;
        InputStreamReader input = null;
        HttpURLConnection conn;
        JSONObject jsonObj = null;
        try {
            url = new URL(urlTemp);
            conn = (HttpURLConnection) url.openConnection();
            //授权
            conn.setRequestProperty("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=");
            //租户身份认证
            conn.setRequestProperty("X-SiteWhere-Tenant", "sitewhere1234567890");
            input = new InputStreamReader(conn.getInputStream(),"utf-8");
            Scanner inputStream = new Scanner(input);
            StringBuffer sb = new StringBuffer();
            while (inputStream.hasNext()) {
                sb.append(inputStream.nextLine());
            }
            jsonObj = JSONObject.parseObject(sb.toString());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jsonObj;
    }
}
