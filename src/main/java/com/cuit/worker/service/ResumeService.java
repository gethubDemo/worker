package com.cuit.worker.service;

import com.cuit.worker.model.Resume;

import java.util.Optional;

public interface ResumeService {
    public void writeResume(Resume resume);
    public void updateResume(Resume resume);
    public Optional<Resume> findResumeById(Integer id);
    public void deleteResumeById(Integer id);
    public Resume findByUserId(Integer id);
}
