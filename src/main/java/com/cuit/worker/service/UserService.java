package com.cuit.worker.service;

import com.cuit.worker.model.UserEntity;
import com.cuit.worker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }
}
