package com.cuit.worker.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Jobintension {
    private int id;
    private String position;
    private String type;
    private String city;
    private Integer salary;
    private Timestamp arrivaltime;
    private String state;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "arrivaltime")
    public Timestamp getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(Timestamp arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jobintension that = (Jobintension) o;
        return id == that.id &&
                Objects.equals(position, that.position) &&
                Objects.equals(type, that.type) &&
                Objects.equals(city, that.city) &&
                Objects.equals(salary, that.salary) &&
                Objects.equals(arrivaltime, that.arrivaltime) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, position, type, city, salary, arrivaltime, state);
    }
}
