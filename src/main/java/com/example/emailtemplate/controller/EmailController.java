package com.example.emailtemplate.controller;

import com.example.emailtemplate.repository.EmailSenderService;
import com.example.emailtemplate.repository.impl.EmailSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

@RestController
public class EmailController {
    @Autowired
    private EmailSenderServiceImpl senderService;

    @GetMapping("/test")
    public String email() throws MessagingException {
        Context context = new Context();
        context.setVariable("name", "John Doe");
        senderService.sendEmailWithInlineImage("dong19069999@gmail.com", "Test Email", context);
        return "Email Sent";
    }
}
