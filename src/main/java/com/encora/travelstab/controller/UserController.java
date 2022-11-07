package com.encora.travelstab.controller;

import com.encora.travelstab.model.User;
import com.encora.travelstab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.create(user);

        return new ResponseEntity< >(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userService.readAll();

        return new ResponseEntity< >(users, HttpStatus.OK);
    }
}
