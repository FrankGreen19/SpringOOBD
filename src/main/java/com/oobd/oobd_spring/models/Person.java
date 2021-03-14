package com.oobd.oobd_spring.models;

import javax.persistence.*;

import static javax.persistence.InheritanceType.*;

@MappedSuperclass
//@Entity
////@Inheritance(strategy = SINGLE_TABLE)
////@Inheritance(strategy = SINGLE_TABLE)
//@Inheritance(strategy = TABLE_PER_CLASS)
public class Person extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String email;

    private String password;

    private String phoneNumber;

    private String firstName;

    private String lastName;

    public Person(String email, String password, String phoneNumber, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return "('" + email + "','" + password + "','" + phoneNumber + "','" + firstName + "','" + lastName + "')";
    }
}
