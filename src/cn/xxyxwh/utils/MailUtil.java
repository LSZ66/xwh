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
        msg = "����ƣ�" + apply.getName() + "<br/>" +
                "���뵥λ��" + apply.getUnit() + "<br/>" +
                "��ϵ��ʽ��" + apply.getContact() + "<br/>" +
                "���벿�ţ�" + getDeptsName(apply.getDepts()) + "<br/>" +
                "�ʱ�䣺" + apply.getExec().replace(',',' ') + "<br/>" +
                "��ص㣺" + apply.getPlace() + "<br/>" +
                "�������" + apply.getDescription();
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

        //���ӵ�Hotmail�ʼ�������
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.live.com");
        props.setProperty("mail.smtp.port", "587");

        //��¼��Hotmail
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("xxyxwh@hotmail.com", "lsz.0929");
            }
        });

        //���������ʼ�
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("xxyxwh@hotmail.com"));
            message.setRecipients(Message.RecipientType.TO, mailTo);
            message.setSubject("�յ�������");
            message.setContent(msg, "text/html;charset=UTF-8");

            Transport.send(message);
            System.out.println("�ɹ������ʼ�����" + mailTo);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
