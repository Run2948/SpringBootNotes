package com.borun.activemq;

import com.borun.config.Constant;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = Constant.DESTINATION)
    public void receiveMessage(String text) {
        System.out.println("接收到：" + text);
    }

}
