package com.cuit.worker.controller;


import com.cuit.worker.model.Audience;
import com.cuit.worker.model.User;
import com.cuit.worker.service.UserService;
import com.cuit.worker.util.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private Audience audience;


    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public ResponseEntity UserRegister(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public ResponseEntity<Audience> Login(@RequestBody User user){


            if (user.getUsername()!=null&&user.getPassword()!=null){
                    audience.setToken(jwtHelper.CreateJWT(1));
                    audience.setUserId(1);
                    return ResponseEntity.ok(audience);
            }
            return null;
    }
}
