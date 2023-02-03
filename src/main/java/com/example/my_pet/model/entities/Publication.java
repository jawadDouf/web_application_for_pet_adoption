package com.example.my_pet.model.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;



@Entity
@Table(name="publications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Publication implements Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     @Column(nullable = false)
     private LocalDate start_date;

     @Column(nullable = false)
     private LocalDate end_date;

    @Column(nullable = false)
    private String publication_description;


    @Column(name = "personId")
    private int personId;

    @Column(name = "animalId")
    private int animalId;
    @ManyToOne
    @JoinColumn(name="personId",insertable = false,updatable = false)
    private Person person;


    @ManyToOne
    @JoinColumn(name="animalId",updatable = false,insertable = false)
    private Animal animal;

    @OneToMany(mappedBy = "publication")
    private List<Comment> comments;



}
