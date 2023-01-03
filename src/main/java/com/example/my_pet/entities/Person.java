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

    @Column(nullable = false)
    private String first_name;

    @Column(columnDefinition = "varchar(20) default 'unknown'")
    private String last_name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String phone_number;

    @OneToMany(mappedBy="person")
    private List<Animal_Keeper> animals;

    @OneToMany(mappedBy = "person")
    private List<Publication> publications;

    @OneToMany(mappedBy = "person")
    private List<Comment> comments;



}
