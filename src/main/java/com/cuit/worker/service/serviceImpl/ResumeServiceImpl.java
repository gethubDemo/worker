package com.cuit.worker.service.serviceImpl;

import com.cuit.worker.model.Resume;
import com.cuit.worker.repository.ResumeRepository;
import com.cuit.worker.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public void writeResume(Resume resume) {
        resumeRepository.save(resume);
    }

    @Override
    public void updateResume(Resume resume) {
        resumeRepository.saveAndFlush(resume);
    }

    @Override
    public Optional<Resume> findResumeById(Integer id) {
        return resumeRepository.findById(id);
    }

    @Override
    public void deleteResumeById(Integer id) {
        resumeRepository.deleteById(id);
    }

    @Override
    public Resume findByUserId(Integer id) {
        return resumeRepository.findByUserId(id);
    }
}
