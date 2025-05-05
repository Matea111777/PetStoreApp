package com.example.petstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = true)
    User Owner;
    String Name;
    @Enumerated(EnumType.STRING)
    Type type;
    String Description;
    LocalDate DateOfBirth;
    BigDecimal Price;
    private Integer rating;

    public Pet(String name, Type type, String description, LocalDate dateOfBirth, BigDecimal price) {

        Name = name;
        this.type = type;
        Description = description;
        DateOfBirth = dateOfBirth;
        Price = price;
    }

    public int getAge() {
        return Period.between(DateOfBirth, LocalDate.now()).getYears();
    }
    public BigDecimal getPrice() {
        int age = getAge();
        if (type == Type.Cat) {
            return BigDecimal.valueOf(age);
        } else if (type == Type.Dog) {
            int dogRating = rating != null ? rating : 0;
            return BigDecimal.valueOf(age + dogRating);
        }
        return BigDecimal.ZERO;
    }



}
