package com.borun.service.impl;

import com.borun.mapper.UserMapper;
import com.borun.pojo.User;
import com.borun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Cacheable("find-users")
    @Override
    public List<User> findUsers(int page, int rows) {
        System.out.println("从数据库读取数据...");
        List<User> list = userMapper.selectByPage(page, rows);
        return list;
    }

    // TODO: redis 集群配置
    @Override
    public String findRedis(String key) {
        return jedisCluster.get(key);
    }
}
