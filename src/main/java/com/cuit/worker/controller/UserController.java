package com.cuit.worker.controller;


import com.cuit.worker.model.User;
import com.cuit.worker.service.UserServiceImpl;
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
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<Optional<User>> findAll(){
        List<User> users = userServiceImpl.findAllUser();
        for (User user: users
             ) {
            System.out.println(user.getUsername());
        }
        Optional<User> user = userServiceImpl.findByUserId(1);
        return ResponseEntity.ok(user);
    }
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public ResponseEntity<Optional<User>> Login(@RequestBody User user){
            if (user.getUsername()!=null&&user.getPassword()!=null){
                    Optional<User> user1  = userServiceImpl.findByUserId(1);
                    return ResponseEntity.ok(user1);
            }
            return null;
    }
}
