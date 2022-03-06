package com.mandana.firstspringbootproject.controllers;


import com.mandana.firstspringbootproject.models.User;
import com.mandana.firstspringbootproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){

        return ResponseEntity.ok(userService.getUsers());
    }


    @PostMapping("/users")
    public ResponseEntity<List<User>> getUsers(@RequestBody User user){

        return ResponseEntity.ok(userService.addUser(user));
    }
}
