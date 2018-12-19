package com.cuit.worker.repository;

import com.cuit.worker.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {
    @Override
    List<Job> findAll();

    @Override
    <S extends Job> S save(S s);

    @Override
    <S extends Job> S saveAndFlush(S s);

    @Override
    void delete(Job job);

    @Override
    Optional<Job> findById(Integer integer);

    @Override
    Page<Job> findAll(Pageable pageable);




}
