package com.example.service2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mails", schema = "service2")
public class Mail {
    @Id
    @Column(name = "id", length = 128, nullable = false)
    private String id;
    @Column(name = "to_email", length = 128, nullable = false)
    private String to;
    @Column(name = "title", length = 128, nullable = false)
    private String title;
    @Column(name = "body")
    private String body;

    public Mail() {
    }

    public Mail(String to, String title, String body) {
        this.to = to;
        this.title = title;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MailDto{" +
                "to='" + to + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
