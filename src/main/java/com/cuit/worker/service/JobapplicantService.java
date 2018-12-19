package com.cuit.worker.service;

import com.cuit.worker.model.Jobapplicant;

import java.util.List;
import java.util.Optional;

public interface JobapplicantService {
    public List<Jobapplicant> findAll();
    public Optional<Jobapplicant> findById(Integer integer);
    public void  save(Jobapplicant jobapplicant);
    public void update(Jobapplicant jobapplicant);
    public void delete(Jobapplicant jobapplicant);
}
