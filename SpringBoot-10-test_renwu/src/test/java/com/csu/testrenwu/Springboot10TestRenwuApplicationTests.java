package com.csu.testrenwu;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot10TestRenwuApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("新年快乐");
        mailMessage.setText("2021，再小的帆也能远航");
        mailMessage.setTo("1402916604@qq.com");
        mailMessage.setFrom("1402916604@qq.com");

        mailSender.send(mailMessage);
    }


    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        //new MimeMessage();或:
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装~
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        //正文
        helper.setSubject("新年快乐");
        helper.setText("<p style='color:red'>再小的帆也能远航</p>",true);

        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\xfs\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\xfs\\Desktop\\1.jpg"));

        helper.setTo("1402916604@qq.com");
        helper.setFrom("1402916604@qq.com");
        mailSender.send(mimeMessage);

    }


    /**
     * 把发送邮件封装成一个方法
     * @param html 判断是否是html格式
     * @param subject
     * @param text
     * @throws MessagingException
     */
    public void setMailSender(Boolean html,String subject,String text) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);
        helper.setSubject(subject);
        helper.setText(text,true);
        helper.addAttachment("1.jpg",new File("C:\\Users\\xfs\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\xfs\\Desktop\\1.jpg"));
        helper.setTo("1402916604@qq.com");
        helper.setFrom("1402916604@qq.com");
        mailSender.send(mimeMessage);
    }
}
