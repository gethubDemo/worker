package com.cuit.worker.controller;


import com.cuit.worker.model.Audience;
import com.cuit.worker.model.Message;
import com.cuit.worker.model.User;
import com.cuit.worker.model.UserRole;
import com.cuit.worker.service.UserRoleService;
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
            UserRole userRole = userRoleService.findByUserId(existsUser.getId());
            audience.setRoleId(userRole.getRoleId());
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

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public ResponseEntity updateUser(@RequestBody User user){
        User existsUser = userService.findById(user.getId()).get();
        Message message = new Message();
        existsUser.setUsername(user.getUsername());
        existsUser.setPassword(user.getPassword());
        existsUser.setAddress(user.getAddress());
        existsUser.setBirthday(user.getBirthday());
        existsUser.setCompany(user.getCompany());
        existsUser.setEmail(user.getEmail());
        existsUser.setPhone(user.getPhone());
        existsUser.setSex(user.getSex());
        try {
            userService.update(existsUser);
        }catch (Exception e){
            message.setMsg("更新用户失败");
            message.setCode(0);
        }
        message.setCode(1);
        message.setMsg("更新用户成功");
        return ResponseEntity.ok(message);
    }


    @RequestMapping(value = "/user/findById",method = RequestMethod.GET)
    public ResponseEntity UserFindById(Integer id){
        Message message = new Message();
        try {
            message.setData( userService.findById(id).get());
            message.setCode(1);

        }catch (Exception e){
            message.setMsg("find User Error");
            message.setCode(0);
        }

        return ResponseEntity.ok(message);
    }

}
