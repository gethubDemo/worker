package com.cuit.worker.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "worker", catalog = "")
public class Userrole {
    private int id;
    private int userId;
    private int roleId;
    private User tUserByUserId;
    private Role tRoleByRoleId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id",insertable = false,updatable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "role_id",insertable = false,updatable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userrole userRole = (Userrole) o;
        return id == userRole.id &&
                userId == userRole.userId &&
                roleId == userRole.roleId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, roleId);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User gettUserByUserId() {
        return tUserByUserId;
    }

    public void settUserByUserId(User tUserByUserId) {
        this.tUserByUserId = tUserByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public Role gettRoleByRoleId() {
        return tRoleByRoleId;
    }

    public void settRoleByRoleId(Role tRoleByRoleId) {
        this.tRoleByRoleId = tRoleByRoleId;
    }
}
