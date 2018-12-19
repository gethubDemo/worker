package com.cuit.worker.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_role", schema = "worker", catalog = "")
public class Role {
    private int id;
    private String role;
    private int code;
//    private Collection<UserRole> userRolesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return id == role1.id &&
                code == role1.code &&
                Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, role, code);
    }

//    @OneToMany(mappedBy = "tRoleByRoleId")
//    public Collection<UserRole> getUserRolesById() {
//        return userRolesById;
//    }
//
//    public void setUserRolesById(Collection<UserRole> userRolesById) {
//        this.userRolesById = userRolesById;
//    }
}
