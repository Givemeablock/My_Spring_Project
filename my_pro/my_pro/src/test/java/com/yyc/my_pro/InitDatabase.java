package com.yyc.my_pro;

import com.yyc.my_pro.Dao.News_DAO;
import com.yyc.my_pro.Dao.User_DAO;
import com.yyc.my_pro.model.News;
import com.yyc.my_pro.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Sql("/sql_init.sql")
public class InitDatabase {
    @Autowired
    User_DAO user;

    @Autowired
    News_DAO n;


    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i ++) {
            User m = new User();
            m.setName(String.format("%d号用户", i));
            m.setId(i);
            m.setPassword(String.format("password%d", i));
            m.setHead_url("www.example.com");
            m.setSalt("");
            user.addUser(m);

            News news = new News();
            news.setComment_count(i);
            Date date = new Date();
            date.setTime(date.getTime() + 1000*3600*5*i);
            news.setCreated_date(date);
            news.setImage("");
            news.setLike_count(i+1);
            news.setUser_id(i);
            news.setTitle(String.format("User%d_Create", i));
            news.setLink("My_link");
            n.addNews(news);

            m.setPassword(String.format("new password%d", i));
            user.UpdatePassword(m);
        }

        for (int i = 0; i < 10; i ++) {
            User u = user.sel_user(i);
            System.out.println(u);
        }



    }

}
