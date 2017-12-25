package com.yyc.my_pro.service;

import com.yyc.my_pro.Dao.UserDAO;
import com.yyc.my_pro.model.User;
import com.yyc.my_pro.tools.userTool;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.security.krb5.internal.Ticket;

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
            return map;
        }
        if (StringUtils.isEmpty(password)) {
            map.put("msgpwd", "密码不能为空");
            return map;
        }
        User user = u.sel_by_name(username);
        if (user != null) {
            map.put("msgname", "用户名已经注册");
            return map;
        }
        else {
            user = new User();
            user.setName(username);
            user.setSalt(UUID.randomUUID().toString().substring(0, 5));
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000)));
            user.setPassword(userTool.MD5(password + user.getSalt()));
            u.addUser(user);
        }
        return map;
    }

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(username)) {
            map.put("usermsg", "姓名不能为空");
            return map;
        }
        if (StringUtils.isEmpty(password)) {
            map.put("pwdmsg", "密码不能为空");
            return map;
        }
        try{
            User user = u.sel_by_name(username);
            if (user == null) {
                map.put("msg", "未注册");
                return map;
            }
            if (!user.getPassword().equals(userTool.MD5(password + user.getSalt()))) {
                map.put("msg", "密码错误");
                return map;
            }

        } catch (Exception e) {}




        return map;
    }
    public List<User> get_alluser() { return u.sel_alluser(); }
}
