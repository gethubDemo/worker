package com.cuit.worker.service;

import com.cuit.worker.model.Jobpublisher;

import java.util.List;

/**
 * @Author: LiJingWen
 * @Date: 2018/12/18 15:40
 * @Version 1.0
 **/
public interface JobpublisherService {
    public List<Jobpublisher> findByUserId(int id);

    public   void deleteByJobId(Integer jobId);
    public  Jobpublisher findByJobId(Integer jobId);

    public void creatPublisher(Jobpublisher jobpublisher);
}
