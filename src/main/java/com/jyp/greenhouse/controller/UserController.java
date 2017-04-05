package com.jyp.greenhouse.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jyp.greenhouse.pojo.Measurement;
import com.jyp.greenhouse.pojo.User;
import com.jyp.greenhouse.service.UserService;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author   : jyp
 * Date     : 2017/3/7 15:49
 * Describe : 用户控制模块
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    UserService userService;

    /**
     * 登录模块
     * @param username
     * @param password
     * @param codevalidate
     * @param session
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(
            String username,
            String password,
            String codevalidate,
            HttpSession session
    ) {
        ModelAndView ret;
        String code = (String) session.getAttribute("codeValidate");
        if (codevalidate == null || !codevalidate.equalsIgnoreCase(code)){
            session.setAttribute("error","验证码错误");
            ret = new ModelAndView("login");
        }
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            session.setAttribute("username",username);
            ret = new ModelAndView(new RedirectView("/index"));
            System.out.println("登陆成功");
        }catch (Exception e){
            ret = new ModelAndView("systemerror");
        }
        return ret;

    }

    /**
     * bootstrap-table访问此URL
     * 根据pageSize和pageNumber获取userList
     * bootstrap-table需要userList用户列表和rows总记录数
     * @param
     * @return
     * @throws IOException
     */
    // @RequestMapping(value = "/list", method = RequestMethod.GET)
    // public String listUsers(Integer pageNumber, Integer pageSize, HttpServletResponse response) throws IOException {
    //     System.out.println("pageNumber--->"+pageNumber);
    //     System.out.println("pageSize--->"+pageSize);
    //     response.setCharacterEncoding("utf-8");
    //     PrintWriter pw = response.getWriter();
    //     int total = userService.countAllUser();
    //     List<User> users = userService.getUserList((pageNumber-1)*pageSize,pageSize);
    //     Map<String, Object> map = new HashMap<>();
    //     map.put("total", total);
    //     map.put("rows", users);
    //     String json = JSONObject.toJSONString(map);
    //     pw.print(json);
    //     return null;
    // }

    @RequestMapping(value = "toEdit",method = RequestMethod.GET)
    public String edit(String username,Model model){
        User user =userService.getUserByName(username);
        model.addAttribute("user",user);
        return "modify_role";
    }


}
