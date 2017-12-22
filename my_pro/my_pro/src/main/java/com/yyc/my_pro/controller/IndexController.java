package com.yyc.my_pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import java.lang.reflect.Method;

@Controller
public class IndexController {
    //此处的注解好像是对调的，
    //经过解释发现value和path是一样的
    @RequestMapping(path = {"/", "/index"})
    @ResponseBody
    public String index() {
        return "Hello Yyc";
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
    public String news() {
        return "news";
    }
}
