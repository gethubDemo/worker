package com.cuit.worker.service;

import com.cuit.worker.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobService {
    public List<Job> findAll();
    public  void delete(Job job);
    public Page<Job> findAll(Pageable pageable);
}
