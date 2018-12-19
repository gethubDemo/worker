package com.cuit.worker.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_job", schema = "worker", catalog = "")
public class Job {
    private int id;
    private String title;
    private String company;
    private String discription;
    private String jobDemand;
    private String type;
    private Integer number;
    private String address;
    private Timestamp endtime;
    private BigInteger salary;
    private Timestamp time;
//    private Collection<Jobapplicant> jobApplicantsById;
//    private Collection<Jobpublisher> jobPublishersById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "discription")
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Basic
    @Column(name = "job_demand")
    public String getJobDemand() {
        return jobDemand;
    }

    public void setJobDemand(String jobDemand) {
        this.jobDemand = jobDemand;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "endtime")
    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "salary")
    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
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
        Job job = (Job) o;
        return id == job.id &&
                Objects.equals(title, job.title) &&
                Objects.equals(company, job.company) &&
                Objects.equals(discription, job.discription) &&
                Objects.equals(jobDemand, job.jobDemand) &&
                Objects.equals(type, job.type) &&
                Objects.equals(number, job.number) &&
                Objects.equals(address, job.address) &&
                Objects.equals(endtime, job.endtime) &&
                Objects.equals(salary, job.salary) &&
                Objects.equals(time, job.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, company, discription, jobDemand, type, number, address, endtime, salary, time);
    }

//    @OneToMany(mappedBy = "tJobByJobId")
//    public Collection<Jobapplicant> getJobApplicantsById() {
//        return jobApplicantsById;
//    }
//
//    public void setJobApplicantsById(Collection<Jobapplicant> jobApplicantsById) {
//        this.jobApplicantsById = jobApplicantsById;
//    }
//
//    @OneToMany(mappedBy = "tJobByJobId")
//    public Collection<Jobpublisher> getJobPublishersById() {
//        return jobPublishersById;
//    }
//
//    public void setJobPublishersById(Collection<Jobpublisher> jobPublishersById) {
//        this.jobPublishersById = jobPublishersById;
//    }
}
