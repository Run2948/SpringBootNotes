package com.borun.service.impl;

import com.borun.mapper.UserMapper;
import com.borun.pojo.User;
import com.borun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.save(user);
    }

    @Override
    public User findUser(Integer id) {
        User user = userMapper.findOne(id);
        return user;
    }

    @Override
    public void delUser(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public Page<User> findUsers(int page, int rows) {
        Page<User> list = userMapper.findAll(new PageRequest(page, rows));
        return list;
    }
}
