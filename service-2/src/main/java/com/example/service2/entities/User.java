package com.example.service2.entities;

import javax.persistence.Column;

public class User {
    private String id;
    private String email;
    private String password;
    private NotificationTime notificationTime;

    public User() {
    }

    public User(String id, String email, String password, NotificationTime notificationTime) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.notificationTime = notificationTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NotificationTime getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(NotificationTime notificationTime) {
        this.notificationTime = notificationTime;
    }
}
