package com.yyc.my_pro.controller;

import com.yyc.my_pro.model.News;
import com.yyc.my_pro.model.User;
import com.yyc.my_pro.model.View_object;
import com.yyc.my_pro.service.News_Service;
import com.yyc.my_pro.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//真实的首页
@Controller
public class HomeController {
    @Autowired
    User_Service u_s;

    @Autowired
    News_Service n_s;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String index(HttpSession session, Model model) {
        List<News> newsList = n_s.get_allNews();
        List<User> userlist = u_s.get_alluser();
        System.out.println(newsList);
        System.out.println(userlist);
        //采用ViewObject来传递关联的信息
        //Freemaker貌似无法这样解析数据
        //
//        List<View_object> vo_list = new ArrayList<>();
//        for (News n : newsList) {
//            View_object vobject = new View_object();
//            vobject.setN(n);
//            System.out.println(n);
//            vobject.setU(u_s.get_user(n.getUser_id()));
//            vo_list.add(vobject);
//        }
//
//        model.addAttribute("vo_list", vo_list);
        //return "home";
        return "test";
    }
}
