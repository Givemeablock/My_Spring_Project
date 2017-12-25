package com.yyc.my_pro.Dao;

import com.yyc.my_pro.model.News;
import com.yyc.my_pro.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDAO {
    String TABLE_NAME = "user";
    String INSERT_FIELD = "name, password, salt, headUrl";
    String VALUE_FIELD = "id, name, password, salt, headUrl";

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELD, ") values (#{name}, #{password}," +
            "#{salt}, #{headUrl})"})
    int addUser(User user);

    @Select({"select * from ", TABLE_NAME, " where id = #{id}"})
    User sel_user(int id);

    @Select({"select * from ", TABLE_NAME, "where name = #{name}"})
    User sel_by_name(String name);

    @Select({"select * from ", TABLE_NAME})
    List<User> sel_alluser();

    @Update({"update ", TABLE_NAME , " set password=#{password} where id=#{id}"})
    void UpdatePassword(User u);

    @Delete({"delete from " , TABLE_NAME, " where id=#{id}"})
    void DeleteUser(int id);

}
