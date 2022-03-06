package com.mandana.firstspringbootproject.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    private String email;
    private String firstName;
    private String lastName;
}
