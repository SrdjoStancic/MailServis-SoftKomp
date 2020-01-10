package com.example.service2.services;

import com.example.service2.dto.MailDto;
import com.example.service2.entities.Mail;
import com.example.service2.entities.User;
import com.example.service2.entities.Weather;
import com.example.service2.repositories.MailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MailService {
    private static final Logger log = LoggerFactory.getLogger(MailService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private RabbitTemplate rabbitMQ;
    private MailRepository mailRepository;

    @Autowired
    public MailService(RabbitTemplate rabbitMQ, MailRepository mailRepository){
        this.rabbitMQ = rabbitMQ;
        this.mailRepository = mailRepository;
    }

    public void sendMails(ArrayList<User> users, String title, Weather weather){
        for (User u: users) {
            this.sendMail(u.getEmail(), title, weather);
        }
    }
    public void sendMail(String toUserEmail, String title, Weather weather){
        String message = "The time is now: "+ dateFormat.format(new Date());
        Mail m = new Mail(toUserEmail, title, message +"\n" + weather.toString());
        this.addMail(m);
        Map<String, String> mailMapper = new HashMap<>();
        mailMapper.put("to", m.getTo());
        mailMapper.put("title", m.getTitle());
        mailMapper.put("body", m.getBody());
        this.rabbitMQ.convertAndSend("mailEvents", mailMapper);
        log.info("Sending email: "+ m);
    }

    private void addMail(Mail m){
        mailRepository.addMail(m);
    }
}
