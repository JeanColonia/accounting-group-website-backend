package com.grupocontable.website.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jeancolonia123@gmail.com");
        message.setTo("engshka123@gmail.com");
        message.setText(body+ "\n"+" Mensaje enviado desde Grupo Contable Website");
        message.setSubject(subject);
        javaMailSender.send(message);
    }

}
