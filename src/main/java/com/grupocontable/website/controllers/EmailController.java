package com.grupocontable.website.controllers;

import com.grupocontable.website.model.Mail;
import com.grupocontable.website.service.Impl.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin("*")
public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService){
        this.emailSenderService = emailSenderService;

    }


    @PostMapping("/email")
    public ResponseEntity<?> enviarCorreo(@RequestBody Mail mail){

        this.emailSenderService.sendEmail(mail.getSubject(), mail.getBody());

        return ResponseEntity.ok(mail);

    }
}
