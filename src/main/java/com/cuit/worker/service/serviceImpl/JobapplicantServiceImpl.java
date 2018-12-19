package com.cuit.worker.service.serviceImpl;

import com.cuit.worker.model.Jobapplicant;
import com.cuit.worker.repository.JobapplicantRepository;
import com.cuit.worker.service.JobapplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobapplicantServiceImpl implements JobapplicantService {
    @Autowired
    private JobapplicantRepository jobapplicantRepository;

    @Override
    public List<Jobapplicant> findAll() {
        return jobapplicantRepository.findAll();
    }

    @Override
    public Optional<Jobapplicant> findById(Integer integer) {
        return jobapplicantRepository.findById(integer);
    }

    @Override
    public void save(Jobapplicant jobapplicant) {
        jobapplicantRepository.save(jobapplicant);

    }

    @Override
    public void update(Jobapplicant jobapplicant) {
        jobapplicantRepository.saveAndFlush(jobapplicant);
    }

    @Override
    public void delete(Jobapplicant jobapplicant) {
        jobapplicantRepository.delete(jobapplicant);
    }
}
