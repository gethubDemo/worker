package com.cuit.worker.controller;

import com.cuit.worker.model.Message;
import com.cuit.worker.model.Resume;
import com.cuit.worker.service.ResumeService;
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
    private Message message;

    @RequestMapping(value = "/resume/write",method = RequestMethod.POST)
    public ResponseEntity resumeWrite(@RequestBody Resume resume){
        try {
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
