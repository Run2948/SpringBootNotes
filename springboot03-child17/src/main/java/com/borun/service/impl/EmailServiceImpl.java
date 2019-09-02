package com.borun.service.impl;

import com.borun.email.EmailConfig;
import com.borun.service.EmailService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public void SendSimpleEmail(String sendTo, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailConfig.getEmailFrom());
        message.setTo(sendTo);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
    }

    @Override
    public void SendAttachmentEmail(String sendTo, String title, String content, File file) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(emailConfig.getEmailFrom());
        helper.setTo(sendTo);
        helper.setSubject(title);
        helper.setText(content);
        helper.addAttachment("详细说明", new FileSystemResource(file));
        mailSender.send(message);
    }

    @Override
    public void SendTemplateEmail(String sendTo, String title, String content, String template) throws MessagingException, IOException, TemplateException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(emailConfig.getEmailFrom());
        helper.setTo(sendTo);
        helper.setSubject(title);

        // 封装邮件模板数据
        Map<String, Object> model = new HashMap<>();
        model.put("title", title);
        model.put("content", content);

        // 得到邮件模板
        Template tmpl = freeMarkerConfigurer.getConfiguration().getTemplate(template);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(tmpl, model);

        helper.setText(html, true);
        mailSender.send(message);
    }
}
