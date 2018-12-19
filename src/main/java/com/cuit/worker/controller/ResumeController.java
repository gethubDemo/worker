package com.cuit.worker.controller;

import com.cuit.worker.model.Message;
import com.cuit.worker.model.Resume;
import com.cuit.worker.model.User;
import com.cuit.worker.service.ResumeService;
import com.cuit.worker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserService userService;
    @Autowired
    private Message message;

    @RequestMapping(value = "/resume/write",method = RequestMethod.POST)
    public ResponseEntity resumeWrite(@RequestBody Resume resume,Integer userId){
        try {
            Optional<User> user = userService.findById(userId);
            resume.settUserByUserId(user.get());
            resumeService.writeResume(resume);
        }catch (Exception e){
            message.setMsg("创建建立失败");
            message.setCode(0);
        }
        message.setCode(1);
        message.setMsg("创建简历成功");
        return ResponseEntity.ok(message);
    }


}
