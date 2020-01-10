package com.example.service2.services;

import com.example.service2.dto.MailDto;
import com.example.service2.dto.weatherDtos.WeatherResponseDto;
import com.example.service2.entities.User;
import com.example.service2.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class Scheduler {

    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);


    //ovo ce biti hendler za dostavljanje podataka sa openWeather-a.
    private MailService mailService;
    private WeatherService weatherService;
    private UserService userService;

    @Autowired
    public Scheduler(MailService mailService, WeatherService weatherService, UserService userService, RabbitTemplate rabbitMQ){
        this.mailService = mailService;
        this.weatherService = weatherService;

        this.userService = userService;
    }
    //hourly
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        ResponseEntity<WeatherResponseDto> response = weatherService.getWeather();
        if(response.getStatusCode() == HttpStatus.OK){
            ArrayList<User> users = userService.getHourlyUsers();

            mailService.sendMails(users, "Hourly weather forecast", Utils.fromWeatherResponseDto(response.getBody()));
        }

    }

    //daily
    @Scheduled(fixedRate = 5000)
    public void reportDaylyTime() {
        ResponseEntity<WeatherResponseDto> response = weatherService.getWeather();
        if(response.getStatusCode() == HttpStatus.OK){
            ArrayList<User> users = userService.getDailyUsers();

            mailService.sendMails(users, "Hourly weather forecast", Utils.fromWeatherResponseDto(response.getBody()));
        }

    }
    //weekly
    @Scheduled(fixedRate = 5000)
    public void reportWeeklyCurrentTime() {
        ResponseEntity<WeatherResponseDto> response = weatherService.getWeather();
        if(response.getStatusCode() == HttpStatus.OK){
            ArrayList<User> users = userService.getWeeklyUsers();

            mailService.sendMails(users, "Hourly weather forecast", Utils.fromWeatherResponseDto(response.getBody()));
        }

    }
}
