package com.cuit.worker.repository;

import com.cuit.worker.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
        UserRole findByUserId(Integer id);
}
