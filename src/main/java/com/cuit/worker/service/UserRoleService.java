package com.cuit.worker.service;


import com.cuit.worker.model.Userrole;

public interface UserRoleService {
    public Userrole findByUserId(Integer id);
}
