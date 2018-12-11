package com.cuit.worker.controller;


import com.cuit.worker.model.User;
import com.cuit.worker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public void findAll(){
        List<User> userEntities = userService.findAllUser();
        for (User user: userEntities
             ) {
            System.out.println(user.getUsername());
        }
    }
}
