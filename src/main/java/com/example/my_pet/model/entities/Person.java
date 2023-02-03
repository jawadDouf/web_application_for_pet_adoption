package com.example.my_pet.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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


     @OneToMany(mappedBy = "person",fetch = FetchType.EAGER)
     private List<Publication> publications;

    @OneToMany(mappedBy = "person")
    private List<Comment> comments;

    @OneToMany(mappedBy = "person")
    private List<Reply> replies;

    @ManyToMany(mappedBy = "persons",fetch = FetchType.EAGER)
    private List<Roles> roles;

    @OneToOne(mappedBy = "person")
    private Image profileImage;


}
