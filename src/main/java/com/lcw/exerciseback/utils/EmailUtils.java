package com.lcw.exerciseback.utils;

import org.springframework.stereotype.Component;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * @Author Licanwei
 * @Description: 邮箱工具类
 * @Date 2022/4/30 19:38
 */
@Component
public class EmailUtils {
    public static boolean sendMail(String to, String emailMsg) {
        try {
            Context context = new InitialContext();
            String emailUser ="3289626462@qq.com"; //(String) context.lookup("java:comp/env/emailUser");
            String emailPwd ="aswrozeaffpecjjd";// (String) context.lookup("java:comp/env/emailPwd");
            String emailHost ="smtp.qq.com";// (String) context.lookup("java:comp/env/emailHost");
            String emailAuth ="true"; //(String) context.lookup("java:comp/env/emailAuth");
            String emailProtocol ="smtp"; //(String) context.lookup("java:comp/env/emailProtocol");
            int emailPort =25; //(Integer) context.lookup("java:comp/env/emailPort");

            // 获取系统环境信息
            Properties props = System.getProperties();
            // 设置邮件服务器
            props.setProperty("mail.smtp.host", emailHost);
            // 设置密码认证
            props.setProperty("mail.smtp.auth", emailAuth);
            // 设置传输协议
            props.setProperty("mail.transport.protocol", emailProtocol);
            // 创建session对象
            Session session = Session.getInstance(props);
            // 设置输出日志
            session.setDebug(true);

            // 邮件发送对象
            MimeMessage message = new MimeMessage(session);
            // 设置发件人
            message.setFrom(new InternetAddress(emailUser));
            // 设置邮件主题
            message.setSubject("验证码邮件");
            // 设置邮件内容
            // message.setText("Welcome to JavaMail World!");
            // 如果带网页内容使用Content发送
            message.setContent((emailMsg), "text/html;charset=utf-8");

            // 获取邮件发送管道
            Transport transport = session.getTransport();
            // 连接管道
            transport.connect(emailHost, emailPort, emailUser, emailPwd);
            // 发送邮件
            transport.sendMessage(message, new Address[] { new InternetAddress(to) });
            // 关闭管道
            transport.close();
            return true;
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
