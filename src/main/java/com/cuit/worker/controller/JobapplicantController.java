package com.cuit.worker.controller;

import com.cuit.worker.service.JobapplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobapplicantController {

    @Autowired
    JobapplicantService jobapplicantService;



}
