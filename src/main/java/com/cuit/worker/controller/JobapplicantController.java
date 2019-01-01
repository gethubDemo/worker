package com.cuit.worker.controller;

import com.cuit.worker.model.Job;
import com.cuit.worker.model.Jobapplicant;
import com.cuit.worker.model.Message;
import com.cuit.worker.model.User;
import com.cuit.worker.service.JobapplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class JobapplicantController {

    @Autowired
    JobapplicantService jobapplicantService;

    @RequestMapping(value = "/jobApplicant/changStatus",method = RequestMethod.GET)
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


    @RequestMapping(value = "/jobApplicant/add",method = RequestMethod.GET)
    public ResponseEntity<Message> addApplicant( Integer jobId,Integer userId ){
        Message message = new Message();
        try {
            Job job = new Job();
            User user = new User();
            job.setId(jobId);
            user.setId(userId);
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            Jobapplicant jobapplicant = new Jobapplicant();

                jobapplicant.setStatus(0);
                jobapplicant.setTime(timestamp);
                jobapplicant.settJobByJobId(job);
                jobapplicant.settUserByUserId(user);
                jobapplicantService.save(jobapplicant);

            message.setCode(1);

        }catch (Exception e){
            e.printStackTrace();
            message.setCode(0);
        }
        return ResponseEntity.ok(message);
    }


}
