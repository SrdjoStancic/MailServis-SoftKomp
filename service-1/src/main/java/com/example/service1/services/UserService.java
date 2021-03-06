package com.example.service1.services;

import com.example.service1.entities.NotificationTime;
import com.example.service1.entities.User;
import com.example.service1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService{

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User login(String userName, String password) {
        User user = this.userRepository.getUserByName(userName);
        if(user == null){
            return null;
        }
        if(user.getPassword().equalsIgnoreCase(password) ){
            return  user;
        }
        return  null;
    }

    public boolean register(String email, String password) {
        User newUSer = new User(email, password);
        if (userRepository.getUserByName(newUSer.getEmail()) != null) {
            return false;
        }
        userRepository.addUser(newUSer);
        return true;
    }

    public List<User> getAllUSers() {
        return userRepository.getAllUsers();
    }

    public User getById(String id) {
        return userRepository.getById(id);
    }

    public User getByUserName(String userName) {
        return userRepository.getUserByName(userName);
    }
    public User setNotificationTime(String userId, NotificationTime notificationTime){
        User u = userRepository.getById(userId);
        if(u != null){
            u.setNotificationTime(notificationTime);
            userRepository.update(u.getId(), u);
        }
        return u;
    }
    public List<User> getHourlyUsers(){
        return  userRepository.getHourlyUsers();
    }
    public List<User> getDaylyUsers(){
        return  userRepository.getDaylyUsers();
    }
    public List<User> getWeeklyUsers(){
        return  userRepository.getWeeklyUsers();
    }
}
