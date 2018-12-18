package com.cuit.worker.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Resume {
    private int id;
    private String selfdescription;
    private String workexperience;
    private String itemexperience;
    private int userId;
    private User userByUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "selfdescription")
    public String getSelfdescription() {
        return selfdescription;
    }

    public void setSelfdescription(String selfdescription) {
        this.selfdescription = selfdescription;
    }

    @Basic
    @Column(name = "workexperience")
    public String getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(String workexperience) {
        this.workexperience = workexperience;
    }

    @Basic
    @Column(name = "itemexperience")
    public String getItemexperience() {
        return itemexperience;
    }

    public void setItemexperience(String itemexperience) {
        this.itemexperience = itemexperience;
    }

    @Basic
    @Column(name = "userId")
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
                Objects.equals(selfdescription, resume.selfdescription) &&
                Objects.equals(workexperience, resume.workexperience) &&
                Objects.equals(itemexperience, resume.itemexperience);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, selfdescription, workexperience, itemexperience, userId);
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
