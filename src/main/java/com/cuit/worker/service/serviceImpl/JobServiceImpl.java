package com.cuit.worker.service.serviceImpl;

import com.cuit.worker.model.Job;
import com.cuit.worker.repository.JobRepository;
import com.cuit.worker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return null;
    }

    @Override
    public void delete(Job job) {

    }

    @Override
    public Page<Job> findAll(Pageable pageable) {
        return jobRepository.findAll(pageable);
    }
}
