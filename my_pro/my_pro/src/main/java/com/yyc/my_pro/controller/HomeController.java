package com.yyc.my_pro.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yyc.my_pro.model.News;
import com.yyc.my_pro.model.User;
import com.yyc.my_pro.model.View_object;
import com.yyc.my_pro.service.News_Service;
import com.yyc.my_pro.service.User_Service;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
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
    //@ResponseBody
    public String index(HttpSession session, Model model) {
        List<News> newsList = n_s.getLatestNews(0, 0, 10);
        //采用ViewObject来传递关联的信息
        //Freemaker貌似无法这样解析数据
        //
        List<View_object> vo_list = new ArrayList<>();
        for (News n : newsList) {
            View_object vobject = new View_object();
            vobject.setN(n);
            //System.out.println(n);
            if (u_s.get_user(n.getUserId()) == null) {}
            else {
                vobject.setU(u_s.get_user(n.getUserId()));
                vo_list.add(vobject);
            }
        }
        //System.out.println(u_s.get_user(1));
        model.addAttribute("vo_list", vo_list);
        return "home";

    }

    @RequestMapping("/user/{userId}")
    public String userIndex(Model model, @PathParam("userId") int userId,
                            @RequestParam(value = "pop", defaultValue = "0") int pop) {
        model.addAttribute("vo_list", n_s.getLatestNews(userId, 0, 10));
        model.addAttribute("pop", pop);
        return "home";
    }
}
