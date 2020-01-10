package com.example.servis3mail.service;

import com.sun.mail.smtp.SMTPTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    private static final String EMAIL_TO = "igor.maxsimovic@gmail.com";

    public void sendEmail(String to, String title, String messageBody){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(EMAIL_TO);
        message.setSubject(title);
        message.setText(messageBody);
        emailSender.send(message);


    }
}
