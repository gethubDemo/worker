package com.cuit.worker.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "user", schema = "worker")
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String username;
    @Column
    private Date birthday;
    @Column
    private int sex;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private String password;

}
