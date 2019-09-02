package com.borun.controller;

import com.borun.pojo.User;
import com.borun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/index")
    public User index() {
        logger.debug("debug日志");
        User user = new User();
        user.setUsername("save");
        user.setPassword("save");
        userService.saveUser(user);
        return user;
    }
}
