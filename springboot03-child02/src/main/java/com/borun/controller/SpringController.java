package com.borun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

    @RequestMapping("/hello")
    @ResponseBody // 默认会去寻找页面，所以指定 ResponseBody
    public String first() {
        return "hello";
    }

}
