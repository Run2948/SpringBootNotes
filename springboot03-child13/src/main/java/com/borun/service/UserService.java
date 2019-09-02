package com.borun.service;

import com.borun.dao.UserDao;
import com.borun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void saveUser(User user) {
        userDao.addUser(user);
    }
}
