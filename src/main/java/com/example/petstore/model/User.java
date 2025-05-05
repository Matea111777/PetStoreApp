package com.example.petstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PetUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String FirstName;
    String LastName;
    String EmailAddress;
    BigDecimal Budget;
    @Version
    private Long version;

    public User(String firstName, String lastName, String emailAddress, BigDecimal budget) {
        FirstName = firstName;
        LastName = lastName;
        EmailAddress = emailAddress;
        Budget = budget;
    }
}
