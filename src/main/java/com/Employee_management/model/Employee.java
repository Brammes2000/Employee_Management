package com.Employee_management.model;


import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data
@Document(collection = "employees")
public class Employee {

    @Id
    private String id;

    @NotBlank(message = "Name field can't be empty")
    private String firstname;

    @NotBlank(message = "Name field can't be empty")
    private  String lastname;

    private String department;

    @Email(message = "Enter valid email")
    private String email;

    @Size(min = 10 ,max = 10, message = "Phone number must be 10 digits")
    private Long phoneno;

    private Double salary;

    public Employee() {

    }

    public Employee(String id, String firstname, String lastname, String department, String email, Long phoneno, Double salary) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.email = email;
        this.phoneno = phoneno;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(Long phoneno) {
        this.phoneno = phoneno;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
