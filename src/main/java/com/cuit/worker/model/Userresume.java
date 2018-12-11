package com.cuit.worker.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Userresume {
    private int id;
    private User userByUserId;
    private Resume resumeByResumeId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userresume that = (Userresume) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "resumeId", referencedColumnName = "id", nullable = false)
    public Resume getResumeByResumeId() {
        return resumeByResumeId;
    }

    public void setResumeByResumeId(Resume resumeByResumeId) {
        this.resumeByResumeId = resumeByResumeId;
    }
}
