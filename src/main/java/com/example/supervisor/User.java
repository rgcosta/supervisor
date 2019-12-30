package com.example.supervisor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String age;
    @OneToMany(mappedBy = "user")
    private List<UserSupervisorAssociation> userSupervisorAssociations;

    public User() {
        this.userSupervisorAssociations = new ArrayList<>();
    }

    public boolean addUserSupervisorAssociations(UserSupervisorAssociation userSupervisorAssociation) {
        this.userSupervisorAssociations.add(userSupervisorAssociation);
//        userSupervisorAssociation.setUser(this);
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
