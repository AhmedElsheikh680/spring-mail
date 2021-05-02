package com.spring.mail.controller;

import com.spring.mail.model.Mail;
import com.spring.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    // http://localhost:8080/mail/sendTextMail
    @GetMapping("/sendTextMail")
    public String sendTextMail(){
        Mail mail = new Mail();
        mail.setTo("ahmedelsheikh680@gmail.com");
        mail.setHeader("Testing Sending Mail From Spring Boot");
        mail.setText("Hello World \n Spring Boot Mail");
        mailService.sendEmail(mail);
        return " Email Send Successfully!!";
    }
}
