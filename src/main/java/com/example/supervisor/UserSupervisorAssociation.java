package com.example.supervisor;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserSupervisorAssociation {

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToOne(cascade = CascadeType.ALL)
    private SubCarrier subCarrier;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    private User supervisor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SubCarrier getSubCarrier() {
        return subCarrier;
    }

    public void setSubCarrier(SubCarrier subCarrier) {
        this.subCarrier = subCarrier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
//        user.addUserSupervisorAssociations(this);
    }

    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        supervisor.setType("Supervisor");
        this.supervisor = supervisor;
//        supervisor.addUserSupervisorAssociations(this);
    }
}
