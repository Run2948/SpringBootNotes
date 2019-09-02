package com.borun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

// 默认情况下扫描的是当前包及当前包的子包，所以可以根据具体情况来指定是否需要扫描
@SpringBootApplication(scanBasePackages = {"com.borun.controller","com.borun.activemq"}) // 组合注解
@EnableJms // 开启ActiveMQ
public class SpringApplications {

    // 入口
    public static void main(String[] args) {
        SpringApplication.run(SpringApplications.class, args);
    }

}


