package com.cuit.worker.controller;

import com.cuit.worker.model.*;
import com.cuit.worker.service.JobService;
import com.cuit.worker.service.JobapplicantService;
import com.cuit.worker.service.JobpublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class JobController {

    @Autowired
    private   JobService jobService;

    @Autowired
    private JobpublisherService jobpublisherService;

    @Autowired
    private JobapplicantService jobapplicantService;

@RequestMapping(value = "/job/list",method = RequestMethod.POST)
public ResponseEntity<Message> findAllJob(@RequestParam(value = "page",defaultValue = "0") int page){
    Message message = new Message();
    try {
        Page<Job> jobs = jobService.findAllJob(page);
        message.setData(jobs);
        message.setCode(1);
    }catch (Exception e){
        e.printStackTrace();
        message.setCode(0);
    }
    return ResponseEntity.ok(message);
}
    @RequestMapping(value = "/job/delete",method = RequestMethod.GET)
    public ResponseEntity<Message> deleteJob(@RequestParam Integer id){
        Message message = new Message();
        try {
            jobapplicantService.deleteByJobId(id);
            jobpublisherService.deleteByJobId(id);
            jobService.deleteJob(id);

            message.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            message.setCode(0);
        }
        return ResponseEntity.ok(message);
    }
    @RequestMapping(value = "/job/update",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Message> updateJob(@RequestBody Job job ){
        Message message = new Message();
        try {
            jobService.updateJob(job);
            message.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            message.setCode(0);
        }
        return ResponseEntity.ok(message);
    }
    @RequestMapping(value = "/job/query",method = RequestMethod.GET)
    public ResponseEntity<Optional<Job>> findJob(@RequestParam Integer id){
        Optional<Job> job = jobService.findByJobId(id);
        return ResponseEntity.ok(job);
    }

    @RequestMapping(value = "/job/creat",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Message> creatJob(@RequestBody Job job){
        Message message = new Message();
        try {
            jobService.creatJob(job);
            message.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            message.setCode(0);
        }

        return ResponseEntity.ok(message);
    }
    @RequestMapping(value = "/job/IdQuery",method = RequestMethod.GET)
    public ResponseEntity<Message> findJobByuserId(@RequestParam Integer id){
        Message message = new Message();
    try {
        List<Jobpublisher> jobpublishers = jobpublisherService.findByUserId(id);

        List<Job> jobIdList = new ArrayList<>();
        for (Jobpublisher job : jobpublishers) {
            jobIdList.add(job.gettJobByJobId());
        }

        message.setCode(1);
        message.setData(jobIdList);
    }catch (Exception e){
        e.printStackTrace();
        message.setCode(0);
}
        return ResponseEntity.ok(message);
    }

    @RequestMapping(value = "/user/IdQuery",method = RequestMethod.GET)
    public ResponseEntity<Message> findUserByJobId(@RequestParam Integer id){
        Message message = new Message();
    try {
        List<Jobapplicant> jobapplicants = jobapplicantService.findByJobId(id);

        List<User> userIdList = new ArrayList<>();
        for (Jobapplicant job : jobapplicants) {
            userIdList.add(job.gettUserByUserId());

        }

        message.setCode(1);
        message.setData(userIdList);
    }catch (Exception e){
        e.printStackTrace();
        message.setCode(0);
    }
        return ResponseEntity.ok(message);
    }

    @RequestMapping(value = "/job/selectJob",method = RequestMethod.GET)
    public ResponseEntity<Message> selectJob(String title){
        Message message = new Message();
        try {
            List<Job> jobs = jobService.findByTitleIsLike(title);
            message.setData(jobs);
            message.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            message.setCode(0);
        }
        return ResponseEntity.ok(message);
    }

}
