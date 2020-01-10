package com.example.service1.dtos;

import com.example.service1.entities.NotificationTime;

public class NotificationDto {
    private String userId;
    private NotificationTime notificationTime;

    public NotificationDto() {
    }

    public NotificationDto(String userId, NotificationTime notificationTime) {
        this.userId = userId;
        this.notificationTime = notificationTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public NotificationTime getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(NotificationTime notificationTime) {
        this.notificationTime = notificationTime;
    }
}
