package com.borun.service.impl;

import com.borun.mapper.UserMapper;
import com.borun.pojo.User;
import com.borun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public List<User> findUsers(int page, int rows) {
        List<User> list = userMapper.selectByPage(page, rows);
        return list;
    }
}
