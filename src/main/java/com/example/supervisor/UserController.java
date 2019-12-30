package com.example.supervisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssociationRepository associationRepository;

    @GetMapping("/doAll")
    public List<UserSupervisorAssociation> doAll() {
        User user = new User();
        user.setFirstName("Romulo");
        user.setLastName("Costa");
        user.setAge("30");

        User user2 = new User();
        user2.setFirstName("Carlos");
        user2.setLastName("Jose");
        user2.setAge("20");

        User supervisor = new User();
        supervisor.setFirstName("Andrew");
        supervisor.setLastName("Parks");

        User supervisor2 = new User();
        supervisor2.setFirstName("John");
        supervisor2.setLastName("Last");
        supervisor2.setAge("50");

        SubCarrier subCarrier = new SubCarrier();
        subCarrier.setCode("P9E");
        subCarrier.setName("City Of LA");

        UserSupervisorAssociation association = new UserSupervisorAssociation();
        association.setDate(new Date());
        association.setUser(user);
        association.setSupervisor(supervisor);
        association.setSubCarrier(subCarrier);

        associationRepository.save(association);

        UserSupervisorAssociation association2 = new UserSupervisorAssociation();
        association2.setDate(new Date());
        association2.setUser(user);
        association2.setSupervisor(supervisor2);
        association2.setSubCarrier(subCarrier);

        associationRepository.save(association2);

        UserSupervisorAssociation association3 = new UserSupervisorAssociation();
        association3.setDate(new Date());
        association3.setUser(user2);
        association3.setSupervisor(user);
        association3.setSubCarrier(subCarrier);

        associationRepository.save(association3);

        UserSupervisorAssociation association4 = new UserSupervisorAssociation();
        association4.setDate(new Date());
        association4.setUser(supervisor);
        association4.setSupervisor(user);
        association4.setSubCarrier(subCarrier);

        associationRepository.save(association4);

        //Try to solve association3
        //Suggestion, elimitate Supervisor Class and work only with User and Association classes. Inside User, there will be
        //a list of supervisor like List<User> supervisors. Try it!

        //Another thing to solve: bi-directional return in json.


        return associationRepository.findAll();
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
