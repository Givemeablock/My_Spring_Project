package com.yyc.my_pro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

//import java.lang.reflect.Method;

@Controller
public class IndexController {
    //此处的注解好像是对调的，
    //经过解释发现value和path是一样的
    @RequestMapping(path = {"/", "/index"})
    @ResponseBody
    public String index(HttpSession m_ses) {
        return "Hello Yyc" + " Current msg:" + m_ses.getAttribute("msg");
    }

    @RequestMapping(value = {"/profile/{groupID}/{userID}"})
    @ResponseBody//必须加这个注解
    public String profile(@PathVariable("groupID") String groupId,
                          @PathVariable("userID") int userID,
                          @RequestParam(value = "type", defaultValue = "1") int type,
                          @RequestParam(value = "key", defaultValue = "xx") String key
                          ) {
        return "<h1>Welcome</h1>" + "<div>"  + groupId + "的" + userID + "</div>"
                + "<div>key:" + key + " type:" + type + "</div>";
    }

    @RequestMapping("/ftl")
    //此处的ftl文件后缀必须为ftl,不能是html
    public String news(Model model) {
        model.addAttribute("value1", "i am value1");
        List<String> colors = Arrays.asList(new String[]{"RED", "BLUE", "YELLOW"});
        model.addAttribute("colors", colors);
        return "news";
    }

    //获取http信息
    @RequestMapping("/request")
    @ResponseBody
    public String request(HttpServletRequest m_request,
                          HttpServletResponse m_response,
                          HttpSession m_session) {
        //获取请求header
        StringBuffer sb = new StringBuffer();
        Enumeration<String> header_names = m_request.getHeaderNames();
        while (header_names.hasMoreElements()) {
            String cur = header_names.nextElement();
            sb.append("Get " + cur + ":::"+ m_request.getHeader(cur) + "<br>");
        }

        for (Cookie cookie: m_request.getCookies()) {
            sb.append("Cookie:" + cookie.getName() + "---" + cookie.getValue() + "<br>");
        }
        return sb.toString();
    }

    //重定向
    @RequestMapping("/redirect/{code}")
    public String red(@PathVariable("code") int code, HttpSession m_ses) {
        //301跳转
//        RedirectView r = new RedirectView("/", true);
//        if (code == 301) {
//            r.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
//        }
        m_ses.setAttribute("msg", "Jump from redirect");
//        return r;
        //302跳转
        return "redirect:/";
    }

    //自定义错误显示
    @RequestMapping("/admin")
    @ResponseBody
    public String admin(@RequestParam(value = "key", required = false) String key) {
        if (key.equals("admin")) {
            return "hello admin";
        }
        throw new IllegalArgumentException("key 错误啦啦啦啦");
    }

    @ExceptionHandler
    @ResponseBody
    public String error_handle(Exception e) {
        return e.getMessage();
    }
}
