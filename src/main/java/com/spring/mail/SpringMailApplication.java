package com.spring.mail;

import com.spring.mail.model.Mail;
import com.spring.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

//@EnableAsync
@SpringBootApplication
public class SpringMailApplication {

    @Autowired
    private MailService mailService;

    public static void main(String[] args) {

        SpringApplication.run(SpringMailApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void sendText(){
//        Mail mail = new Mail();
//        mail.setHeader("Testing Sending Mail From Spring Boot");
//        mail.setText("Hell World \n Spring Boot Mail");
//        mail.setTo("ahmedelsheikh680@gmail.com");
//        mailService.sendMessageByMail(mail);
//        System.out.println("OK");
//    }



}
