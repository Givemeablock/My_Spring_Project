package com.yyc.my_pro.service;

import com.yyc.my_pro.Dao.User_DAO;
import com.yyc.my_pro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_Service {
    @Autowired
    private User_DAO u;

    public User get_user(int id) {
        return u.sel_user(id);
    }

    public List<User> get_alluser() { return u.sel_alluser(); }
}
