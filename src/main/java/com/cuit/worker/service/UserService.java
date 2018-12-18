package com.cuit.worker.service;

import com.cuit.worker.model.Role;
import com.cuit.worker.model.User;

import java.util.Optional;

public interface UserService {
    public Optional<User> findById(Integer id);
    public User findByUserName(String username);
    public void save(User user);
    public void update(User user);
}
