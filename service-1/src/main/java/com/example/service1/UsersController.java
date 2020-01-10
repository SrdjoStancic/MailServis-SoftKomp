package com.example.service1;

import com.example.service1.dtos.NotificationDto;
import com.example.service1.entities.User;
import com.example.service1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "any")
@RequestMapping(value = "users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService){
        this.userService=userService;
    }
    @PostMapping(path = "/register", produces = "application/json", consumes = "application/json")
    public ResponseEntity Register(@RequestBody User user){
        if(this.userService.register(user.getEmail(), user.getPassword()))
            return ResponseEntity.ok().build();
        return ResponseEntity.status(500).build();
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> Login(@RequestBody User user){
        User tmpUser = this.userService.login(user.getEmail(), user.getPassword());
        if(tmpUser != null)
            return ResponseEntity.ok(tmpUser);
        return ResponseEntity.status(500).build();
    }

    @PostMapping(path = "/notificationTime", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> SetNotificationTime(@RequestBody NotificationDto notification){
        User tmpUser = this.userService.setNotificationTime(notification.getUserId(), notification.getNotificationTime());
        if(tmpUser != null)
            return ResponseEntity.ok(tmpUser);
        return ResponseEntity.status(500).build();
    }

    @GetMapping(path = "/hourly", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> GetHourlyUsers(){
        return ResponseEntity.ok(this.userService.getHourlyUsers());
    }
    @GetMapping(path = "/dayly", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> GetDaylyUsers(){
        return ResponseEntity.ok(this.userService.getDaylyUsers());
    }
    @GetMapping(path = "/weekly", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> GetWeeklyUsers(){
        return ResponseEntity.ok(this.userService.getWeeklyUsers());
    }
}
