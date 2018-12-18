package com.cuit.worker.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "job_publisher", schema = "worker", catalog = "")
public class JobPublisher {
    private int id;
    private int userId;
    private int jobId;
    private Timestamp time;
    private User tUserByUserId;
    private Job tJobByJobId;

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
    @Column(name = "job_id",insertable = false,updatable = false)
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobPublisher that = (JobPublisher) o;
        return id == that.id &&
                userId == that.userId &&
                jobId == that.jobId &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, jobId, time);
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
    @JoinColumn(name = "job_id", referencedColumnName = "id", nullable = false)
    public Job gettJobByJobId() {
        return tJobByJobId;
    }

    public void settJobByJobId(Job tJobByJobId) {
        this.tJobByJobId = tJobByJobId;
    }
}
