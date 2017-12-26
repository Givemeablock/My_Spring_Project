package com.yyc.my_pro.service;

import com.yyc.my_pro.Dao.LoginTicketDAO;
import com.yyc.my_pro.Dao.UserDAO;
import com.yyc.my_pro.model.LoginTicket;
import com.yyc.my_pro.model.User;
import com.yyc.my_pro.tools.userTool;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.misc.UUDecoder;
import sun.security.krb5.internal.Ticket;

import java.util.*;

@Service
public class User_Service {
    @Autowired
    private UserDAO u;

    @Autowired
    private LoginTicketDAO l;

    /**
     *
     * @param id
     * @return
     */
    public User get_user(int id) {
        return u.sel_user(id);
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
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
            map.put("ticket", add_ticket(user.getId()));
        }

        return map;
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
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
            map.put("ticket", add_ticket(user.getId()));
        } catch (Exception e) {}
        return map;
    }

    /**
     *
     * @param userid
     * @return
     */
    public String add_ticket(int userid) {
        LoginTicket lgticket = new LoginTicket();
        lgticket.setUserId(userid);
        lgticket.setStatus(0);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        lgticket.setExpired(date);
        lgticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        l.addTicket(lgticket);
        return lgticket.getTicket();
    }

    public List<User> get_alluser() { return u.sel_alluser(); }
}
