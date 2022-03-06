package com.mandana.firstspringbootproject.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String email;
    private String firstName;
    private String lastName;
}
