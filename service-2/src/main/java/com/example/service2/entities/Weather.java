package com.example.service2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weather", schema = "service2")
public class Weather {

    @Id
    @Column(name = "id", length = 128, nullable = false)
    private String id;
    @Column(name = "temp")
    private float temp;
    @Column(name = "pressure")
    private float pressure;
    @Column(name = "humidity")
    private float humidity;
    @Column(name = "temp_min")
    private float temp_min;
    @Column(name = "temp_max")
    private float temp_max;
    @Column(name = "name", length = 128, nullable = false)
    private String name;
    @Column(name = "timezone")
    private float timezone;

    public Weather(){}
    public Weather(String id, float temp, float pressure, float humidity, float temp_min, float temp_max, String name, float timezone) {
        this.id = id;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.name = name;
        this.timezone = timezone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTimezone() {
        return timezone;
    }

    public void setTimezone(float timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", name='" + name + '\'' +
                ", timezone=" + timezone +
                '}';
    }
}
