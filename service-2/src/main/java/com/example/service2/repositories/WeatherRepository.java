package com.example.service2.repositories;

import com.example.service2.entities.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class WeatherRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Weather> getAllWeathers() {
        TypedQuery<Weather> weathersQuery = em.createQuery("select s from Weather s", Weather.class);
        return weathersQuery.getResultStream().collect(Collectors.toList());

    }

    public Weather getWeatherByName(String name) {
        TypedQuery<Weather> weatherQuery = em.createQuery("select s from Weather s where s.name = :name", Weather.class);
        weatherQuery.setParameter("name", name);
        try {
            return weatherQuery.getResultStream().findFirst().get();
        }catch (NoSuchElementException ex){
            return  null;
        }
    }

    public Weather getById(String id){
        TypedQuery<Weather> weatherQuery = em.createQuery("select u from Weather u where u.id = :id", Weather.class);
        weatherQuery.setParameter("id", id);
        try {
            return  weatherQuery.getResultStream().findFirst().get();
        }catch (NoSuchElementException ex){
            return  null;
        }
    }
    @Transactional
    public Weather addWeather(Weather weather) {
        // setting uuid as ID to methods and parameters
        weather.setId(UUID.randomUUID().toString());
        em.persist(weather);
        em.flush();
        return weather;
    }

}
