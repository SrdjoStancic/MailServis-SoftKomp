package com.example.service2.dto.weatherDtos;

import java.io.Serializable;

public class Coord implements Serializable {
    private float lon;
    private float lat;

    public Coord(){}
    // Getter Methods

    public float getLon() {
        return lon;
    }

    public float getLat() {
        return lat;
    }

    // Setter Methods

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
}
