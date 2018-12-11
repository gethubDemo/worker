package com.cuit.worker.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Userjobintension {
    private int id;
    private User userByUserId;
    private Jobintension jobintensionByJobId;

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
        Userjobintension that = (Userjobintension) o;
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
    @JoinColumn(name = "jobId", referencedColumnName = "id", nullable = false)
    public Jobintension getJobintensionByJobId() {
        return jobintensionByJobId;
    }

    public void setJobintensionByJobId(Jobintension jobintensionByJobId) {
        this.jobintensionByJobId = jobintensionByJobId;
    }
}
