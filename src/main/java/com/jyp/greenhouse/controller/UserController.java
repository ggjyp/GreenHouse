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
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "toEditPwd",method = RequestMethod.GET)
    public String toEditPwd(String username,Model model){
        User user =userService.getUserByName(username);
        model.addAttribute("user",user);
        return "modify_password";
    }

    /**
     * 修改密码
     * @param username
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "editPassword", method = RequestMethod.POST)
    public HashMap editPassword(
            String username,
            String oldPwd,
            String newPwd
    )  {
        HashMap<String ,String> map = new HashMap<>();
        System.out.println("username-->"+username);
        System.out.println("oldPwd-->"+oldPwd);
        System.out.println("newPwd-->"+newPwd);
        User user = userService.getUserByName(username);
        if (user.getPassword().equals(oldPwd)){
            if (userService.updatePassword(username,newPwd)) {
                //修改成功
                map.put("result","success");
            }
            else {
                //修改失败
                map.put("result","failed");
            }
        }
        else {
            //旧密码错误
            map.put("result","error");
        }
        System.out.println(map.toString());
        return map;
    }


}
