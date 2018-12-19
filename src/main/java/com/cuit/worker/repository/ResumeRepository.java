package com.cuit.worker.repository;

import com.cuit.worker.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Integer> {
    Resume findByUserId(Integer id);
}
