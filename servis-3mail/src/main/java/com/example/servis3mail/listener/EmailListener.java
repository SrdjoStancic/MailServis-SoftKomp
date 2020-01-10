package com.example.servis3mail.listener;

import com.example.servis3mail.dtos.MailDto;
import com.example.servis3mail.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "mailEvents")
public class EmailListener {

    private EmailService emailService;

    public EmailListener(EmailService emailService){
        this.emailService = emailService;
    }

    @RabbitHandler
    public void receive(Map<String, String> in) {
        MailDto m = new MailDto(in.get("to"),in.get("title"),in.get("body"));
        emailService.sendEmail(in.get("to"),in.get("title"),in.get("body"));
        System.out.println(" [x] Received '" + m + "'");
    }
}
