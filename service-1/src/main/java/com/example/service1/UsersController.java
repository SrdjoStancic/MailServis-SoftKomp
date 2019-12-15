package com.example.service1;

import com.example.service1.entities.User;
import com.example.service1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "u")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService){
        this.userService=userService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity Register(@RequestBody User user){
        if(this.userService.register(user.getEmail(), user.getPassword()))
            return ResponseEntity.ok().build();
        return ResponseEntity.status(500).build();
    }

    @PostMapping(path = "/login")
    public ResponseEntity<User> Login(@RequestBody User user){
        User tmpUser = this.userService.login(user.getEmail(), user.getPassword());
        if(tmpUser != null)
            return ResponseEntity.ok(tmpUser);
        return ResponseEntity.status(500).build();
    }

}
