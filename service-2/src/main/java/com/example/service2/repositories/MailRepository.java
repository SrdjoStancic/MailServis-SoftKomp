package com.example.service2.repositories;

import com.example.service2.entities.Mail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
public class MailRepository {

    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public Mail addMail(Mail mail) {
        // setting uuid as ID to methods and parameters
        mail.setId(UUID.randomUUID().toString());
        em.persist(mail);
        em.flush();
        return mail;
    }
}
