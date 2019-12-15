package com.example.service1.repositories;

import com.example.service1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public List<User> getAllUsers() {
        TypedQuery<User> usersQuery = em.createQuery("select s from User s", User.class);
        return usersQuery.getResultStream().collect(Collectors.toList());

    }

    public User getUserByName(String email) {
        TypedQuery<User> userQuery = em.createQuery("select s from User s where s.email = :email", User.class);
        userQuery.setParameter("email", email);
        try {
            return userQuery.getResultStream().findFirst().get();
        }catch (NoSuchElementException ex){
            return  null;
        }
    }

    public User getById(String id){
        TypedQuery<User> userQuery = em.createQuery("select u from User u where u.id == :id", User.class);
        userQuery.setParameter("id", id);
        try {
            return  userQuery.getResultStream().findFirst().get();
        }catch (NoSuchElementException ex){
            return  null;
        }
    }
    @Transactional
    public User addUser(User user) {
        // setting uuid as ID to methods and parameters
        user.setId(UUID.randomUUID().toString());
        em.persist(user);
        em.flush();
        return user;
    }
}
