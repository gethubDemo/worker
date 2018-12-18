package com.cuit.worker.service;


import com.cuit.worker.model.UserRole;

public interface UserRoleService {
    public UserRole findByUserId(Integer id);
}
