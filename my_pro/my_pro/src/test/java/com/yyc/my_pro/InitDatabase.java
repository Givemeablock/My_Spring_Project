package com.yyc.my_pro;

import com.yyc.my_pro.Dao.NewsDAO;
import com.yyc.my_pro.Dao.UserDAO;
import com.yyc.my_pro.model.News;
import com.yyc.my_pro.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Sql("/sql_init.sql")
public class InitDatabase {
    @Autowired
    UserDAO user;

    @Autowired
    NewsDAO n;


    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i ++) {
            User m = new User();
            m.setName(String.format("%d号用户", i));
            m.setId(i);
            m.setPassword(String.format("password%d", i));
            m.setHeadUrl("www.example.com");
            m.setSalt("");
            user.addUser(m);

            News news = new News();
            news.setCommentCount(i);
            Date date = new Date();
            date.setTime(date.getTime() + 1000*3600*5*i);
            news.setCreatedate(date);
            news.setImage("");
            news.setLikeCount(i+1);
            news.setTitle(String.format("User%d_Create___", i));
            news.setUserId(i);
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
