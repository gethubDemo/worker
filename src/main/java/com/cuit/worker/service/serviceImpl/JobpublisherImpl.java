package com.cuit.worker.service.serviceImpl;

import com.cuit.worker.model.Jobpublisher;
import com.cuit.worker.repository.JobpublisherRepository;
import com.cuit.worker.service.JobpublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LiJingWen
 * @Date: 2018/12/18 15:41
 * @Version 1.0
 **/
@Service
public class JobpublisherImpl implements JobpublisherService {
    @Autowired
    JobpublisherRepository jobpublisherRepository;



    @Override
    public List<Jobpublisher> findByUserId(int id) {
        return jobpublisherRepository.findByUserId(id);
    }

    @Override
    public void deleteByJobId(Integer jobId) {
        jobpublisherRepository.deleteByJobId(jobId);
    }

    @Override
    public Jobpublisher findByJobId(Integer jobId) {
        return jobpublisherRepository.findByJobId(jobId);
    }

    @Override
    public void creatPublisher(Jobpublisher jobpublisher) {
        jobpublisherRepository.save(jobpublisher);
    }
}
