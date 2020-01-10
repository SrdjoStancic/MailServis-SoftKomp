package com.example.service2.services;

import com.example.service2.dto.weatherDtos.WeatherResponseDto;
import com.example.service2.repositories.WeatherRepository;
import com.example.service2.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private RestTemplate template;
    private static final String URL = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=400da2b10e94a777ee3749b7879f2925";
    private WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public ResponseEntity<WeatherResponseDto> getWeather(){
        template = new RestTemplate();
        ResponseEntity<WeatherResponseDto> response = template.getForEntity(URL, WeatherResponseDto.class);

        weatherRepository.addWeather(Utils.fromWeatherResponseDto(response.getBody()));

        return response;
    }
}
