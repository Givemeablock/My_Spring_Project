package com.yyc.my_pro.service;

import com.yyc.my_pro.Dao.News_DAO;
import com.yyc.my_pro.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class News_Service {
    @Autowired
    private News_DAO news;

    public List<News> getLatestNews(int offset, int limit) {
        return news.selectByUserIdAndOffset(offset, limit);
    }

    public List<News> get_allNews() {
        return news.get_allnews();
    }
}
