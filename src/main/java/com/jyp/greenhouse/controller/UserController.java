package com.jyp.greenhouse.controller;

import com.jyp.greenhouse.pojo.User;
import com.jyp.greenhouse.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

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
     * 登录模块，后期需要优化体验，登录失败需要弹出提示框，参考插件layer
     * @param username
     * @param password
     * @param codevalidate
     * @param attr
     * @param session
     * @param response
     * @return
     */
    @RequestMapping("/login2")
    public String login(String username, String password, String codevalidate, RedirectAttributes attr, HttpSession session, HttpServletResponse response) {
        String code = (String) session.getAttribute("codeValidate");
        if (codevalidate == null || !codevalidate.equalsIgnoreCase(code)){
            attr.addFlashAttribute("error","验证码错误");
            System.out.println("验证码错误");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(username,password) ;
        try {
            subject.login(token);
            session.setAttribute("username", username);
            System.out.println("登陆成功");
            return "redirect:../index" ;
        }catch (Exception e){
            System.out.println("登录失败");
            return "login" ;
        }
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(
            String username,
            String password,
            String codevalidate,
            HashMap map,
            HttpSession session
    ) {
        ModelAndView ret = null;
        String code = (String) session.getAttribute("codeValidate");
        if (codevalidate == null || !codevalidate.equalsIgnoreCase(code)){
            map.put("error","验证码错误");
            ret = new ModelAndView("login");
        }
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            map.put("username",username);
            ret = new ModelAndView("redirect:../index");
            System.out.println("登陆成功");
        }catch (Exception e){
            ret = new ModelAndView("systemerror");
        }
        return ret;

    }
}
