package com.borun.mapper;

import com.borun.pojo.User;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert("insert into user(username,password,created_at,updated_at) values(#{user.username,jdbcType=VARCHAR},#{user.password,jdbcType=VARCHAR}," +
            "#{user.createdAt,jdbcType=BIGINT},#{user.updatedAt,jdbcType=BIGINT})")
    void addUser(@Param("user") User user);

    @Select("select * from user limit #{page},#{rows}")
    List<User> selectByPage(@Param("page") int page,@Param("rows") int rows);
}