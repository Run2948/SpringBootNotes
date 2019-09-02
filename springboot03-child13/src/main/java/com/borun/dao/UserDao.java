package com.borun.dao;

import com.borun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(User user) {
        jdbcTemplate.update("insert into `user`(username,password,created_at,updated_at) values(?,?,?,?)",
                new Object[]{user.getUsername(), user.getPassword(), System.currentTimeMillis(),
                        System.currentTimeMillis()});
    }

}
