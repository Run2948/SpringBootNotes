package com.borun.controller;

import com.borun.pojo.User;
import com.borun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/index/{page}/{rows}")
    public List<User> getUsers(@PathVariable Integer page,@PathVariable Integer rows) {
        logger.debug("查询用户");
        List<User> users = userService.findUsers(page, rows);
        return users;
    }

    @ResponseBody
    @RequestMapping("/add")
    public User saveUser() {
        logger.debug("添加用户");
        User user = new User();
        user.setUsername("save");
        user.setPassword("save");
        user.setCreatedAt(System.currentTimeMillis());
        user.setUpdatedAt(System.currentTimeMillis());
        userService.addUser(user);
        return user;
    }

    @ResponseBody
    @RequestMapping("/redis")
    public String findRedis(){
        return userService.findRedis("find-users");
    }
}
