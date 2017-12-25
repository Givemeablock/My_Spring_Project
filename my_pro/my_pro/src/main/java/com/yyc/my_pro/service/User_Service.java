package com.yyc.my_pro.service;

import com.yyc.my_pro.Dao.UserDAO;
import com.yyc.my_pro.model.User;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class User_Service {
    @Autowired
    private UserDAO u;

    public User get_user(int id) {
        return u.sel_user(id);
    }

    public Map<String, Object> reigster(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(username)) {
            map.put("msgname", "用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            map.put("msgpwd", "密码不能为空");
        }
        User user = u.sel_by_name(username);
        if (user != null) {
            map.put("msgname", "用户名已经注册");
        }
        else {
            user = new User();
            user.setName(username);
            user.setSalt(UUID.randomUUID().toString().substring(0, 5));
            user.setHeadUrl(String.format("httpZ://images.nowcoder.com/head/%dt.png", new Random().nextInt()));
            user.setPassword();
        }
        return map;
    }
    public List<User> get_alluser() { return u.sel_alluser(); }
}
