package com.borun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/stomp")
public class StompController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // 发送页面
    @GetMapping("/send")
    public String send() {
        return "send";
    }

    // 接收界面
    @GetMapping("/receive")
    public String receive() {
        return "receive";
    }

    // 对特定用户发送消息界面
    @GetMapping("/sendUser")
    public String sendUser() {
        return "sendUser";
    }

    // 接收用户消息页面
    @GetMapping("/receiveUser")
    public String receiveUser() {
        return "receiveUser";
    }

    // 定义消息请求路径
    @MessageMapping("/send")
    // 定义结果发送到特定路径
    @SendTo("/sub/chat")
    public String sendMsg(String value) {
        // 客户端发送消息到服务端
        System.out.println("receive message from client:" + value);
        // 这里返回消息到'/sub/chat'订阅路径
        return value;
    }

    // 将消息发送给特定用户
    @MessageMapping("/sendUser")
    public void sendToUser(Principal principal, String body) {
        String srcUser = principal.getName();
        // 解析用户和消息
        String[] args = body.split(",");
        String desUser = args[0];
        String message = "[" + srcUser + "] send message to you:" + args[1];
        // 将消息发送到监听地址的特定用户
        simpMessagingTemplate.convertAndSendToUser(desUser, "/queue/customer", message);
    }
}