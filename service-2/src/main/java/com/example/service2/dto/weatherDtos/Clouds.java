package com.example.service2.dto.weatherDtos;

import java.io.Serializable;

public class Clouds implements Serializable {
    private float all;

    public  Clouds(){}
    // Getter Methods

    public float getAll() {
        return all;
    }

    // Setter Methods

    public void setAll(float all) {
        this.all = all;
    }
}
