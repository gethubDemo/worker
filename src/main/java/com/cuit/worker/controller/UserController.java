package com.cuit.worker.controller;


import com.cuit.worker.model.Audience;
import com.cuit.worker.model.Message;
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

    @Autowired
    private Message message;

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public ResponseEntity UserRegister(@RequestBody User user){
        User existsUser = userService.findByUserName(user.getUsername());
        if (existsUser!= null){
            message.setCode(0);
            message.setMsg("该用户已存在");
        }else userService.save(user);
        return ResponseEntity.ok(message);
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
