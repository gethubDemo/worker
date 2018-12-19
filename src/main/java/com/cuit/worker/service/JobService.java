package com.cuit.worker.service;

import com.cuit.worker.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface JobService {
    public List<Job> findAll();
    public  void delete(Job job);
    public Page<Job> findAll(Pageable pageable);


    public Page<Job> findAllJob(int page);
    public Optional<Job> findByJobId(Integer id);
    public Job creatJob(Job job);
    public Job updateJob(Job job);
    public void deleteJob(int id);
}
