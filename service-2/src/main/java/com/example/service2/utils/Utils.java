package com.example.service2.utils;

import com.example.service2.dto.MailDto;
import com.example.service2.dto.weatherDtos.WeatherDto;
import com.example.service2.dto.weatherDtos.WeatherResponseDto;
import com.example.service2.entities.Mail;
import com.example.service2.entities.Weather;

public class Utils {
    public static MailDto toDto(Mail mail){
        return new MailDto(mail.getTo(), mail.getTitle(), mail.getBody());
    }
    public static Mail fromDto(MailDto mail){
        return new Mail(mail.getTo(), mail.getTitle(), mail.getBody());
    }

    public static WeatherDto toDto(Weather weather){
        return new WeatherDto(weather.getId(), weather.getTemp(), weather.getPressure(), weather.getHumidity(), weather.getTemp_min(), weather.getTemp_max(), weather.getName(),weather.getTimezone());
    }
    public static Weather fromDto(WeatherDto weather){
        return new Weather(weather.getId(), weather.getTemp(), weather.getPressure(), weather.getHumidity(), weather.getTemp_min(), weather.getTemp_max(), weather.getName(),weather.getTimezone());
    }

    public static Weather fromWeatherResponseDto(WeatherResponseDto dto){
        return  new Weather("", dto.getMain().getTemp(), dto.getMain().getPressure(),dto.getMain().getHumidity(),dto.getMain().getTemp_min(), dto.getMain().getTemp_max(), dto.getName(),dto.getTimezone());
    }
}
