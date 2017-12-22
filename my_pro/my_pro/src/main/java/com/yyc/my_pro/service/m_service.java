package com.yyc.my_pro.service;

import org.springframework.stereotype.Service;
//依赖注入，不用new对象
@Service
public class m_service {
    public String say() {
        return "This is my-news service";
    }
}
