package com.cuit.worker.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_resume", schema = "worker", catalog = "")
public class Resume {
    private int id;
    private String selfDescription;
    private String workExperience;
    private String itemExperience;
    private int userId;
    private User tUserByUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "self_description")
    public String getSelfDescription() {
        return selfDescription;
    }

    public void setSelfDescription(String selfDescription) {
        this.selfDescription = selfDescription;
    }

    @Basic
    @Column(name = "work_experience")
    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    @Basic
    @Column(name = "item_experience")
    public String getItemExperience() {
        return itemExperience;
    }

    public void setItemExperience(String itemExperience) {
        this.itemExperience = itemExperience;
    }

    @Basic
    @Column(name = "user_id",insertable = false,updatable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return id == resume.id &&
                userId == resume.userId &&
                Objects.equals(selfDescription, resume.selfDescription) &&
                Objects.equals(workExperience, resume.workExperience) &&
                Objects.equals(itemExperience, resume.itemExperience);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, selfDescription, workExperience, itemExperience, userId);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User gettUserByUserId() {
        return tUserByUserId;
    }

    public void settUserByUserId(User tUserByUserId) {
        this.tUserByUserId = tUserByUserId;
    }
}
