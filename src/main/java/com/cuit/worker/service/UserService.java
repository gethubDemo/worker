package com.cuit.worker.service;

import com.cuit.worker.model.User;
import com.cuit.worker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
