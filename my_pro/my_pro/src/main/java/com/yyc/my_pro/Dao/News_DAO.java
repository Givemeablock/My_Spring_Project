package com.yyc.my_pro.Dao;

import com.yyc.my_pro.model.News;
import jdk.nashorn.internal.objects.annotations.Where;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface News_DAO {
    String TABLE_NAME = "news";
    String INSERT_FIELDS = " title, link, image, likeCount, commentCount, createddate, userId ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{title},#{link},#{image},#{likeCount},#{commentCount},#{createddate},#{userId})"})
    int addNews(News news);

    //用xml的方式选出
    @Select({"Select * from ", TABLE_NAME})
    List<News> selectByUserIdAndOffset();
            //@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);

    @Select({"select * from", TABLE_NAME})
    List<News> get_allnews();
//    @Select({"Select * from ", TABLE_NAME, "where id = #{id}"})
//    News getNews()
}
