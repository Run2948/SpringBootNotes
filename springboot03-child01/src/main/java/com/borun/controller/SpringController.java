package com.borun.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SpringController {

    // 入口
    public static void main(String[] args) {
        SpringApplication.run(SpringController.class, args);
    }

    @RequestMapping("/hello")
    @ResponseBody // 默认会去寻找页面，所以指定 ResponseBody
    public String first() {
        return "hello";
    }

}
