package com.example.my_pet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "persons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length=20)
    private String first_name;

    @Column(columnDefinition = "varchar(20) default 'unknown'")
    private String last_name;

    @Column(nullable = false,columnDefinition = "varchar(255)")
    private String email;

    @Column(nullable = false,columnDefinition = "varchar(255)")
    private String password;

    @Column(nullable = false,columnDefinition = "varchar(200)")
    private String adresse;

    @Column(nullable = false,columnDefinition = "varchar(200)")
    private String phone_number;

    @OneToMany(mappedBy="person")
    private List<Animal_Keeper> animals;

    @OneToMany(mappedBy = "person")
    private List<Publication> publications;

    @OneToMany(mappedBy = "person")
    private List<Comment> comments;



}
