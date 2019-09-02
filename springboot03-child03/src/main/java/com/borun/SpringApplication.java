package com.borun;

import org.springframework.boot.autoconfigure.SpringBootApplication;

// 默认情况下扫描的是当前包及当前包的子包，所以可以根据具体情况来指定是否需要扫描
@SpringBootApplication(scanBasePackages = {"com.borun.controller"}) // 组合注解
public class SpringApplication {
    // 入口
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }

}
