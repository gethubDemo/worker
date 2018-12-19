package com.cuit.worker.service.serviceImpl;

import com.cuit.worker.model.Userrole;
import com.cuit.worker.repository.UserRoleRepository;
import com.cuit.worker.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public Userrole findByUserId(Integer id) {
        return userRoleRepository.findByUserId(id);
    }
}
