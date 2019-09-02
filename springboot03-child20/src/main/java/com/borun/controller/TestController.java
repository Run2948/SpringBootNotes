package com.borun.controller;

import com.borun.activemq.Producer;
import com.borun.config.Constant;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;
import java.util.Date;

@Controller
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private Producer producer;

    @ResponseBody
    @RequestMapping("/index")
    public String send() {
        logger.debug("ActiveMQ测试");
        // 点对点消息
        Destination des = new ActiveMQQueue(Constant.DESTINATION);
        for (int i = 0; i < 3; i++) {
            producer.sendMessage(des, new Date().toString());
        }
        return "success";
    }

}
