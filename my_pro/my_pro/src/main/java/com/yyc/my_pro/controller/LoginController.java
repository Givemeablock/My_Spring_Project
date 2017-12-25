package com.yyc.my_pro.controller;

import com.yyc.my_pro.model.News;
import com.yyc.my_pro.model.View_object;
import com.yyc.my_pro.service.News_Service;
import com.yyc.my_pro.service.User_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//真实的首页
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    User_Service u_s;

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String reg(Model model, @RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam(value = "rember", defaultValue = "0") int remember) {

    }




}
