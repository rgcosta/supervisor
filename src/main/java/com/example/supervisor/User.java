package com.example.supervisor;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String age;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserSupervisorAssociation> userSupervisorAssociations = new ArrayList<>();
    @Column(name = "dtype", insertable = false, updatable = false)
    private String type;

    public void addUserSupervisorAssociations(UserSupervisorAssociation userSupervisorAssociation) {
        this.userSupervisorAssociations.add(userSupervisorAssociation);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
