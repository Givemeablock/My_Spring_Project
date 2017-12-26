package com.yyc.my_pro.controller;

import com.yyc.my_pro.model.News;
import com.yyc.my_pro.model.View_object;
import com.yyc.my_pro.service.News_Service;
import com.yyc.my_pro.service.User_Service;
import com.yyc.my_pro.tools.userTool;
import freemarker.template.utility.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//真实的首页
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    User_Service u_s;

    @RequestMapping(value = "/reg", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String reg(Model model, @RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam(value = "rember", defaultValue = "0") int remember,
                      HttpServletResponse response) {
        try {
            Map<String, Object> newusermsg = u_s.reigster(username, password);
            if (newusermsg.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", newusermsg.get("ticket").toString());
                cookie.setPath("/");
                if (remember > 0) {
                    cookie.setMaxAge(3600*24*5);
                }
                response.addCookie(cookie);
                return userTool.getJSONString(0, "注册成功");
            }
            return userTool.getJSONString(1, newusermsg);
        } catch (Exception e) {
            logger.error("注册异常" + e.getMessage());
            return userTool.getJSONString(1, "注册异常");
        }

    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String login(@RequestParam("username") String name, @RequestParam("password") String password,
                        @RequestParam(value = "rember", defaultValue = "0") int remember,
                        HttpServletResponse response) {
        try {
            Map<String , Object> loginmsg = u_s.login(name, password);
            if (!loginmsg.get("ticket").toString().isEmpty()) {
                Cookie cookie = new Cookie("ticket", loginmsg.get("ticket").toString());
                cookie.setPath("/");
                if (remember > 0) {
                    cookie.setMaxAge(3600*24*5);
                }
                response.addCookie(cookie);
                return userTool.getJSONString(0, "登陆成功");
            }
            return userTool.getJSONString(1, "登陆失败");
        }
        catch (Exception e) {
            logger.error("登陆异常" + e.getMessage());
            return userTool.getJSONString(1, "登陆异常");
        }
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(@CookieValue("ticket") String ticket) {
        u_s.logout(ticket);
        return "redirect:/";
    }


}
