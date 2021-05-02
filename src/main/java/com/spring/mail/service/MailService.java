package com.spring.mail.service;

import com.spring.mail.model.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public void sendMessageByMail(Mail mail){
        SimpleMailMessage simpleMailMessage  = new SimpleMailMessage();
        simpleMailMessage.setFrom("ahmedelsheikh680@gmail.com");
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject(mail.getHeader());
        simpleMailMessage.setText(mail.getText());
        javaMailSender.send(simpleMailMessage);
    }
}
