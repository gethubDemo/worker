package com.cuit.worker.controller;

import com.cuit.worker.model.Job;
import com.cuit.worker.model.Message;
import com.cuit.worker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @RequestMapping(value = "/jobList",method = RequestMethod.GET)
    public ResponseEntity<Message> findAllJob(int page){
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable  = new PageRequest(page,10,sort);

        Page<Job> jobs= jobService.findAll(pageable);

        for(Job job:jobs){
            System.out.println(job.getId());
            System.out.println("1");
        }
        Message message = new Message();
        message.setData(jobs);
        return ResponseEntity.ok(message);
    }




}
