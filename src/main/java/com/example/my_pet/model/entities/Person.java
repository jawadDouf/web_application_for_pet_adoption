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
@Setter
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


    @ManyToMany(mappedBy = "persons",fetch = FetchType.EAGER)
    private List<Roles> roles;

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPhone_number() {
        return phone_number;
    }


    public List<Animal_Keeper> getAnimals() {
        return animals;
    }


    public List<Comment> getComments() {
        return comments;
    }

    public List<Roles> getRoles() {
        return roles;
    }
}
