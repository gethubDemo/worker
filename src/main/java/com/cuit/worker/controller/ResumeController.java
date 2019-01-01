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


@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/resume/write",method = RequestMethod.POST)
    public ResponseEntity resumeWrite(@RequestBody Resume resume){
        Message message = new Message();
        try {
            User user = userService.findById(resume.getUserId()).get();
            resume.settUserByUserId(user);
            resumeService.writeResume(resume);
        }catch (Exception e){
            message.setMsg("创建简历失败");
            message.setCode(0);
        }
        message.setCode(1);
        message.setMsg("创建简历成功");
        return ResponseEntity.ok(message);
    }

    @RequestMapping(value = "/resume/update",method = RequestMethod.POST)
    public ResponseEntity resumeUpdate(@RequestBody Resume resume){
        Message message = new Message();
        try {
            Resume existsResume = resumeService.findByUserId(resume.getUserId());
            existsResume.setItemExperience(resume.getItemExperience());
            existsResume.setSelfDescription(resume.getSelfDescription());
            existsResume.setWorkExperience(resume.getWorkExperience());
            resumeService.updateResume(existsResume);
        }catch (Exception e){
            message.setMsg("更新简历失败");
            message.setCode(0);
        }
        message.setCode(1);
        message.setMsg("更新简历成功");
        return ResponseEntity.ok(message);
    }

    @RequestMapping(value = "/resume/find",method = RequestMethod.GET)
    public ResponseEntity findResumeByUserId(Integer userId){
        Message message = new Message();
        Resume resume = resumeService.findResumeById(userId).get();
        if (resume  == null){
            message.setMsg("简历为空");
            message.setCode(0);
        }
        message.setCode(1);
        message.setMsg("查询简历成功");
        message.setData(resume);
        return ResponseEntity.ok(message);
    }
}
