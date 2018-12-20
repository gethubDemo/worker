package com.cuit.worker.service.serviceImpl;

import com.cuit.worker.model.Job;
import com.cuit.worker.repository.JobRepository;
import com.cuit.worker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    @Override
    public Page<Job> findAllJob(int page) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page,10, sort);
        Page<Job> pages = jobRepository.findAll(pageable);

        return pages;
    }
    @Override
    public Optional<Job> findByJobId(Integer id){
        return jobRepository.findById(id);
    }
    @Override
    public Job creatJob(Job job){return  jobRepository.save(job);}

    @Override
    public Job updateJob(Job job){return jobRepository.saveAndFlush(job);}

    @Override
    public void deleteJob(int id){
        jobRepository.deleteById(id);
    }

    @Override
    public List<Job> findAllByTitle(String title) {
        return jobRepository.findAllTitle(title);
    }

}
