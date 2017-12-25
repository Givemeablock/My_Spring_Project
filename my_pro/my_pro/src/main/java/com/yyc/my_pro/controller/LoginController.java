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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String reg(Model model, @RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam(value = "rember", defaultValue = "0") int remember) {
        try {
            Map<String, Object> newusermsg = u_s.reigster(username, password);
            if (newusermsg.isEmpty()) {
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
    public String login(@Param("username") String name, @Param("password") String password,
                        @RequestParam(value = "rember", defaultValue = "0") int rememberme) {
        Map<String , Object> map = new HashMap<>();
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            map.put("msg", "不能为空");
        }
        return "还未完成";
    }


}
