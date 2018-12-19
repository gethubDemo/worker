package com.cuit.worker.repository;

import com.cuit.worker.model.Jobapplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobapplicantRepository extends JpaRepository<Jobapplicant,Integer> {
    @Override
    List<Jobapplicant> findAll();

    @Override
    Optional<Jobapplicant> findById(Integer integer);

    @Override
    <S extends Jobapplicant> S save(S s);

    @Override
    <S extends Jobapplicant> S saveAndFlush(S s);

    @Override
    void delete(Jobapplicant jobapplicant);

    List<Jobapplicant> findByJobId(Integer jobId);

    List<Jobapplicant> findByUserIdAndJobId(Integer userId, Integer jobId);

    @Transactional
    void deleteByJobId(Integer jobId);
}
