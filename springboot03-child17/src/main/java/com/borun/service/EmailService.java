package com.borun.service;

import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;

public interface EmailService {

    // 发送简单邮件
    void SendSimpleEmail(String sendTo,String title,String content);

    // 发送带附件的邮件
    void SendAttachmentEmail(String sendTo, String title, String content, File file) throws MessagingException;

    // 发送模板邮件
    void SendTemplateEmail(String sendTo, String title, String content, String template) throws MessagingException, IOException, TemplateException;
}
