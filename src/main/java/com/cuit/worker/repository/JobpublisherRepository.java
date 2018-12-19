package com.cuit.worker.repository;

import com.cuit.worker.model.Jobpublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LiJingWen
 * @Date: 2018/12/18 15:37
 * @Version 1.0
 **/
public interface JobpublisherRepository extends JpaRepository<Jobpublisher,Integer> {
//        public List<Jobpublisher> findByTJobByJobId();
        List<Jobpublisher> findByUserId(Integer id);
        @Transactional
        void deleteByJobId(Integer jobId);

}

