package com.yyc.my_pro.Dao;

import com.yyc.my_pro.model.News;
import com.yyc.my_pro.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface User_DAO {
    String TABLE_NAME = "user";
    String INSERT_FIELD = "name, password, salt, head_url";
    String VALUE_FIELD = "id, name, password, salt, head_url";

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELD, ") values (#{name}, #{password}," +
            "#{salt}, #{head_url})"})
    int addUser(User user);

    @Select({"select * from ", TABLE_NAME, " where id = #{id}"})
    User sel_user(int id);

    @Update({"update ", TABLE_NAME , " set password=#{password} where id=#{id}"})
    void UpdatePassword(User u);

    @Delete({"delete from " , TABLE_NAME, " where id=#{id}"})
    void DeleteUser(int id);

}
