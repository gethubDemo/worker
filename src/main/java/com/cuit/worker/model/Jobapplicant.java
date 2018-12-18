package com.cuit.worker.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Jobapplicant {
    private int id;
    private Timestamp time;
    private Integer status;
    private User userByUserId;
    private Job jobByJobId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jobapplicant that = (Jobapplicant) o;
        return id == that.id &&
                Objects.equals(time, that.time) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, time, status);
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
    public Job getJobByJobId() {
        return jobByJobId;
    }

    public void setJobByJobId(Job jobByJobId) {
        this.jobByJobId = jobByJobId;
    }
}
