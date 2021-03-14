package com.oobd.oobd_spring.models;

import javax.persistence.*;

@Entity
public class Worker extends Person {

    @Column
    private String position;

    public Worker(String email, String password, String phoneNumber, String firstName, String lastName, String position) {
        super(email, password, phoneNumber, firstName, lastName);
        this.position = position;
    }

    public Worker() {}

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
