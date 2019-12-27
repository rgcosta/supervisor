package com.example.supervisor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supervisor extends User {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL)
    private List<UserSupervisorAssociation> userSupervisorAssociations = new ArrayList<>();


    public void addUserSupervisorAssociations(UserSupervisorAssociation userSupervisorAssociation) {
        this.userSupervisorAssociations.add(userSupervisorAssociation);
    }


    public List<UserSupervisorAssociation> getUserSupervisorAssociations() {
        return userSupervisorAssociations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
