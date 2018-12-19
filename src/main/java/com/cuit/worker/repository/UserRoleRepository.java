package com.cuit.worker.repository;

import com.cuit.worker.model.Userrole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<Userrole,Integer> {
        Userrole findByUserId(Integer id);
//        Userrole findByTUserByUserId(Integer id);
}
