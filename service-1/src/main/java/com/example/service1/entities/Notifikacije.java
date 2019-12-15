package com.example.service1.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "obavjestenja")
public class Notifikacije {
    @Id
    @Column(name = "id", length = 128, nullable = false)
    private String id;

    @Column(name = "type", length = 64, nullable = false)
    private TipNotifikacije type;

    @Column(name = "timeType", length = 64, nullable = false)
    private VrijemeNotifikacije timeType;

    @ManyToMany
    @JoinTable
    private List<User> users;
}
