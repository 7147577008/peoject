package com.it.util;

import com.it.entity.User;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/6/15.
 */
public class EmailUtil {
    private static Logger logger = LoggerFactory.getLogger(EmailUtil.class);

    /**
     * 发送HTML格式的邮件
     *
     * @param address 邮件发送的地址
     * @param subject 邮件发送的名称开头
     * @param html    邮件发送的内容
     */
    public static void sendEmail(String address, String subject, String html) {
        HtmlEmail email = new HtmlEmail();
        email.setAuthentication(Config.get("mail.username"), Config.get("mail.password"));
        email.setCharset(Config.get("mail.charset"));
        email.setSmtpPort(Integer.parseInt(Config.get("mail.port", "25")));
        email.setHostName(Config.get("mail.hostname"));

        try {
            email.setFrom(Config.get("mail.fromEmail"));
            email.setHtmlMsg(html);
            email.setSubject(subject);
            email.addTo(address);
            email.send();
            logger.debug("{}邮件发送成功", address);
        } catch (EmailException e) {
            logger.error("{}邮件发送失败", address);
            throw new RuntimeException("邮件发送失败", e);

        }
    }
}