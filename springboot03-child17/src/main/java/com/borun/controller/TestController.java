package com.borun.controller;

import com.borun.service.EmailService;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private EmailService emailService;

    @ResponseBody
    @RequestMapping("/send")
    public String sendEmail() {
        logger.debug("简单邮件发送");
        emailService.SendSimpleEmail("1004850985@qq.com", "你好", "明天去你家玩！");
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/send/file")
    public String sendFileEmail() {
        logger.debug("带附件的邮件发送");
        try {
            File file = ResourceUtils.getFile("classpath:static/绩点计算.csv");
            emailService.SendAttachmentEmail("370209562@qq.com", "请帮我计算一下绩点", "你好，请帮我计算一下绩点，我的具体分数信息在附件中。", file);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/send/tmpl")
    public String sendTemplateEmail() {
        logger.debug("模板邮件发送");
        try {
            emailService.SendTemplateEmail("370209562@qq.com", "你好", "你好，明天去你家玩。", "info.html");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
