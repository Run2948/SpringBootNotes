package com.borun.service.impl;

import com.borun.mapper.UserMapper;
import com.borun.pojo.User;
import com.borun.pojo.UserExample;
import com.borun.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> findUsers(int page, int rows) {
        UserExample example = new UserExample();
        PageHelper.startPage(page,rows);
        List<User> list= userMapper.selectByExample(example);
        return list;
    }
}
