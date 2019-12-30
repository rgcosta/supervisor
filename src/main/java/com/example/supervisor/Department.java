package com.example.supervisor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public Department(String name) {
        this();
        this.name = name;
    }

    public boolean addEmployee(Employee emp) {
        if(this.employees.add(emp)) {
            emp.setDepartment(this);
            return true;
        }
        return false;
    }

    public boolean removeEmployee(Employee emp) {
        if(employees.remove(emp)) {
            emp.setDepartment(this);
            return true;
        }
        return false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }
}
