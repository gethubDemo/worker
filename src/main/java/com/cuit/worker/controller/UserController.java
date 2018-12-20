package com.cuit.worker.controller;


import com.cuit.worker.model.Audience;
import com.cuit.worker.model.Message;
import com.cuit.worker.model.User;
import com.cuit.worker.model.Userrole;
import com.cuit.worker.service.UserRoleService;
import com.cuit.worker.service.UserService;
import com.cuit.worker.util.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private Audience audience;


    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public ResponseEntity UserRegister(@RequestBody User user){
        User existsUser = userService.findByUserName(user.getUsername());
        Message message = new Message();
        if (existsUser!= null){
            message.setCode(0);
            message.setMsg("该用户已存在");
        }else {
            userService.save(user);
            message.setCode(1);
            message.setMsg("注册成功");
        }
        return ResponseEntity.ok(message);
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public ResponseEntity<Message> Login(@RequestBody User user){
        User existsUser = userService.findByUserName(user.getUsername());
        Message message = new Message();
        if (existsUser == null){
            message.setCode(0);
            message.setMsg("不存在这个用户");
            return ResponseEntity.ok(message);
        }else if (existsUser.getPassword().equals(user.getPassword())){
            audience.setToken(jwtHelper.CreateJWT(existsUser.getId()));
            audience.setUserId(existsUser.getId());
            //Integer roleId = existsUser.getUserRolesById().iterator().next().getRoleId();
          Userrole userRole = userRoleService.findByUserId(existsUser.getId());
            audience.setRoleId(userRole.getId());
            message.setData(audience);
            message.setCode(1);
            message.setMsg("登录成功");
            return ResponseEntity.ok(message);
        }else {
            message.setCode(0);
            message.setMsg("密码错误");
            return ResponseEntity.ok(message);
        }
    }



}
