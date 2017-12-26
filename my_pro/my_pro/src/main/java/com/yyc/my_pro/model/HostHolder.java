package com.yyc.my_pro.model;


import org.springframework.stereotype.Component;
//表示当前用户是谁
//一次访问中
@Component
public class HostHolder {
    //线程本地变量
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
