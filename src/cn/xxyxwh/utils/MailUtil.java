package cn.xxyxwh.utils;

import cn.xxyxwh.model.Apply;
import cn.xxyxwh.service.DeptService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;

public class MailUtil extends Thread {

    private String mailTo, msg;

    public MailUtil(String mailTo, Apply apply) {
        this.mailTo = mailTo;
        msg = "活动名称：" + apply.getName() + "<br/>" +
                "申请单位：" + apply.getUnit() + "<br/>" +
                "联系方式：" + apply.getContact() + "<br/>" +
                "申请部门：" + getDeptsName(apply.getDepts()) + "<br/>" +
                "活动时间：" + apply.getExec().replace(',',' ') + "<br/>" +
                "活动地点：" + apply.getPlace() + "<br/>" +
                "活动描述：" + apply.getDescription();
    }

    @Override
    public void run() {
        sendMail();
    }

    private ArrayList<String> getDeptsName(String id) {
        DeptService service = new DeptService();
        return service.getDeptsNameById(id.split(","));
    }

    private void sendMail() {

        //连接到Hotmail邮件服务器
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.live.com");
        props.setProperty("mail.smtp.port", "587");

        //登录到Hotmail
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("xxyxwh@hotmail.com", "lsz.0929");
            }
        });

        //创建电子邮件
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("xxyxwh@hotmail.com"));
            message.setRecipients(Message.RecipientType.TO, mailTo);
            message.setSubject("收到新申请");
            message.setContent(msg, "text/html;charset=UTF-8");

            Transport.send(message);
            System.out.println("成功发送邮件到：" + mailTo);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
