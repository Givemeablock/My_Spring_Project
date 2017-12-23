package com.yyc.my_pro.controller;

import com.yyc.my_pro.service.News_Service;
import com.yyc.my_pro.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

//真实的首页
@Controller
public class HomeController {
    @Autowired
    User_Service u_s;

    @Autowired
    News_Service n_s;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    //@ResponseBody
    public String index(HttpSession session) {
        return "home";
    }
}
