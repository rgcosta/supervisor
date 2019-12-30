package com.example.supervisor;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Supervisor extends User {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "supervisor")
    private List<UserSupervisorAssociation> userSupervisorAssociations;

    public Supervisor() {
        this.userSupervisorAssociations = new ArrayList<>();
    }

    public boolean addUserSupervisorAssociations(UserSupervisorAssociation userSupervisorAssociation) {
        this.userSupervisorAssociations.add(userSupervisorAssociation);
//        userSupervisorAssociation.setSupervisor(this);
        return true;
    }


//    public List<UserSupervisorAssociation> getUserSupervisorAssociations() {
//        return Collections.unmodifiableList(this.userSupervisorAssociations);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
