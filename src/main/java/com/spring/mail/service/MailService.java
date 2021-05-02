package com.spring.mail.service;

import com.spring.mail.model.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    // Send A Noraml Text Email
//    @Async
//    public void sendMessageByMail(Mail mail){
//        SimpleMailMessage simpleMailMessage  = new SimpleMailMessage();
//        simpleMailMessage.setFrom("ahmedelsheikh680@gmail.com");
//        simpleMailMessage.setTo(mail.getTo());
//        simpleMailMessage.setSubject(mail.getHeader());
//        simpleMailMessage.setText(mail.getText());
//        javaMailSender.send(simpleMailMessage);
//    }

    // Send A Noraml Text Email
    public void sendTextEmail(Mail mail){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom("ahmedelsheikh680@gmail.com");
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject(mail.getHeader());
        simpleMailMessage.setText(mail.getText());
        javaMailSender.send(simpleMailMessage);

    }

    // Send Html Mail
    public void sendHtmlMail(Mail mail) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        // true = Multipart Message
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setTo(mail.getTo());
        mimeMessageHelper.setSubject(mail.getHeader());
        mimeMessageHelper.setText(mail.getText(), true);
        javaMailSender.send(mimeMessage);
    }

    // Send Html Mail With Attachement
    public void sendHtmlMailWithAttachement(Mail mail) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        // true = Multipart Message
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(mail.getTo());
        mimeMessageHelper.setSubject(mail.getHeader());
        mimeMessageHelper.setText(mail.getText(), true);
        String img = "mail.jpg";
        String img2 = "mail2.jpg";
        mimeMessageHelper.addAttachment(img, new ClassPathResource(img));
        mimeMessageHelper.addAttachment(img2, new ClassPathResource(img2));

        javaMailSender.send(mimeMessage);

    }




















}
