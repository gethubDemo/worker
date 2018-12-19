package com.cuit.worker.controller;

import com.cuit.worker.model.*;
import com.cuit.worker.service.JobService;
import com.cuit.worker.service.JobapplicantService;
import com.cuit.worker.service.JobpublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
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

//    @RequestMapping(value = "/jobList",method = RequestMethod.GET)
////    public ResponseEntity<Message> findAllJob(int page){
////        Sort sort = new Sort(Sort.Direction.ASC, "id");
////        Pageable pageable  = new PageRequest(page,10,sort);
////
////        Page<Job> jobs= jobService.findAll(pageable);
////
////        for(Job job:jobs){
////            System.out.println(job.getId());
////            System.out.println("1");
////        }
////        Message message = new Message();
////        message.setData(jobs);
////        return ResponseEntity.ok(message);
////    }
@RequestMapping(value = "/jobList",method = RequestMethod.GET)
public ResponseEntity<Message> findAllJob(int page){
    Page<Job> jobs= jobService.findAllJob(page);

    for(Job job:jobs){
        System.out.println(job.getId());
        System.out.println("1");
    }
    Message message = new Message();
    message.setData(jobs);
    return ResponseEntity.ok(message);
}
    @RequestMapping(value = "/jobDelete",method = RequestMethod.GET)
    public ResponseEntity<Message> deleteJob(@RequestParam Integer id){

        jobapplicantService.deleteByJobId(id);
        jobpublisherService.deleteByJobId(id);
        jobService.deleteJob(id);
        Message message = new Message();
        message.setCode(1);
        return ResponseEntity.ok(message);
    }
    @RequestMapping(value = "/jobUpdate",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Message> updateJob(@RequestBody Job job ){
        jobService.updateJob(job);
        Message message = new Message();
        message.setCode(1);
        return ResponseEntity.ok(message);
    }
    @RequestMapping(value = "/jobQuery",method = RequestMethod.GET)
    public ResponseEntity<Optional<Job>> findJob(@RequestParam Integer id){
        Optional<Job> job = jobService.findByJobId(id);
        return ResponseEntity.ok(job);
    }

    @RequestMapping(value = "/creatJob",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Message> creatJob(@RequestBody Job job){
        jobService.creatJob(job);
        Message message = new Message();
        message.setCode(1);
        return ResponseEntity.ok(message);
    }
    @RequestMapping(value = "/jobIdQuery",method = RequestMethod.GET)
    public ResponseEntity<Message> findJobByuserId(@RequestParam Integer id){
        System.out.println( id +"----------");
        List<Jobpublisher> jobpublishers = jobpublisherService.findByUserId(id);

       List<Job> jobIdList = new ArrayList<>();
        for(Jobpublisher job :jobpublishers){
           jobIdList.add(job.gettJobByJobId());
            System.out.println(job.gettJobByJobId().getId()+"----------");
        }
        Message message = new Message();
        message.setCode(1);
        message.setData(jobIdList);
        return ResponseEntity.ok(message);
    }

    @RequestMapping(value = "/userIdQuery",method = RequestMethod.GET)
    public ResponseEntity<Message> findUserByJobId(@RequestParam Integer id){

        List<Jobapplicant> jobapplicants = jobapplicantService.findByJobId(id);

        List<User> userIdList = new ArrayList<>();
        for(Jobapplicant job :jobapplicants){
            userIdList.add(job.gettUserByUserId());

        }
        Message message = new Message();
        message.setCode(1);
        message.setData(userIdList);
        return ResponseEntity.ok(message);
    }









}
