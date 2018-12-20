package com.cuit.worker.repository;

import com.cuit.worker.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sun.awt.SunHints;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer> , JpaSpecificationExecutor<Job> {
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

    @Query(value = "select * from t_job a where a.title like CONCAT('%',:title,'%')",nativeQuery=true)
    List<Job> findAllTitle(@Param("title") String title);


}
