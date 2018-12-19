package com.cuit.worker.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_user", schema = "worker", catalog = "")
public class User {
    private int id;
    private String username;
    private String password;
    private Date birthday;
    private int sex;
    private String email;
    private String phone;
    private String address;
    private String company;
//    private Collection<Jobapplicant> jobApplicantsById;
//    private Collection<Jobpublisher> jobPublishersById;
//    private Collection<Resume> tResumesById;
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
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "sex")
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                sex == user.sex &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(address, user.address) &&
                Objects.equals(company, user.company);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, birthday, sex, email, phone, address, company);
    }

//    @OneToMany(mappedBy = "tUserByUserId")
//    public Collection<Jobapplicant> getJobApplicantsById() {
//        return jobApplicantsById;
//    }
//
//    public void setJobApplicantsById(Collection<Jobapplicant> jobApplicantsById) {
//        this.jobApplicantsById = jobApplicantsById;
//    }
//
//    @OneToMany(mappedBy = "tUserByUserId")
//    public Collection<Jobpublisher> getJobPublishersById() {
//        return jobPublishersById;
//    }
//
//    public void setJobPublishersById(Collection<Jobpublisher> jobPublishersById) {
//        this.jobPublishersById = jobPublishersById;
//    }
//
//    @OneToMany(mappedBy = "tUserByUserId")
//    public Collection<Resume> gettResumesById() {
//        return tResumesById;
//    }
//
//    public void settResumesById(Collection<Resume> tResumesById) {
//        this.tResumesById = tResumesById;
//    }
//
//    @OneToMany(mappedBy = "tUserByUserId")
//    public Collection<UserRole> getUserRolesById() {
//        return userRolesById;
//    }

//    public void setUserRolesById(Collection<UserRole> userRolesById) {
//        this.userRolesById = userRolesById;
//    }
}
