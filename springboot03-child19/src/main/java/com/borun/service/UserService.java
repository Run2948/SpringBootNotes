package com.borun.service;

import com.borun.pojo.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> findUsers(int page, int rows);

    // TODO: redis 集群配置
    String findRedis(String key);

}
