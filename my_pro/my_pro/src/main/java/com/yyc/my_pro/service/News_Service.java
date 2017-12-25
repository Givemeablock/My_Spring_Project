package com.yyc.my_pro.service;

import com.yyc.my_pro.Dao.NewsDAO;
import com.yyc.my_pro.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class News_Service {
    @Autowired
    private NewsDAO news;

    public List<News> getLatestNews(int userId, int offset, int limit) {
        return news.selectByUserIdAndOffset(userId, offset, limit);
    }

    public List<News> get_allNews() {
        return news.get_allnews();
    }
}
