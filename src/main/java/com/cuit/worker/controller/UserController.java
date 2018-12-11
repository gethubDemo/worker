package com.cuit.worker.controller;


import com.cuit.worker.model.User;
import com.cuit.worker.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAllUser();
        for (User user: users
             ) {
            System.out.println(user.getUsername());
        }
        Optional<User> user = userService.findByUserId(1);
        return ResponseEntity.ok(users);
    }
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public ResponseEntity<User> Login(@RequestBody User user){
            if (user.getUsername()!=null&&user.getPassword()!=null){
                    return ResponseEntity.ok(user);
            }
            return ResponseEntity.ok(user);
    }
}
