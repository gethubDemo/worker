package com.cuit.worker.controller;

import com.cuit.worker.model.Job;
import com.cuit.worker.model.Jobapplicant;
import com.cuit.worker.model.Message;
import com.cuit.worker.service.JobapplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobapplicantController {

    @Autowired
    JobapplicantService jobapplicantService;

    @RequestMapping(value = "/jobapplicant/changStatus",method = RequestMethod.GET)
    public ResponseEntity<Message> changStatus(Integer applicantUserId, @RequestParam(value = "status", defaultValue = "0")Integer status, Integer jobId ){
        Message message = new Message();
    try {
        List<Jobapplicant> jobapplicants = jobapplicantService.findByUserIdAndJobId(applicantUserId,jobId);
        Jobapplicant jobapplicant =  jobapplicants.get(0);
        jobapplicant.setStatus(status);
        jobapplicantService.update(jobapplicant);
        message.setCode(1);

    }catch (Exception e){
        message.setCode(0);
    }
        return ResponseEntity.ok(message);
    }



}
