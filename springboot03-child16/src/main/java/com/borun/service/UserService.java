package com.borun.service;

import com.borun.pojo.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User findUser(Integer id);

    void delUser(Integer id);

    Page<User> findUsers(int page, int rows);
}
