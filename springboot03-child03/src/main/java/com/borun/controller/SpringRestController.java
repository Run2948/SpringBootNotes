package com.borun.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRestController {

    @RequestMapping("/ok")
    public String ok() {
        return "ojbk";
    }

    // Restful 风格
    @RequestMapping("/info/{msg}")
    public String show(@PathVariable String msg) {
        return "show" + msg;
    }
}
