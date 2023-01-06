package com.example.my_pet.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal_Keeper implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Animal_Keeper_id", nullable = false)
    private int id;

    @ManyToOne
    private Animal animal;

    @ManyToOne
    private Person person;

    public int getId() {
        return id;
    }


    public Animal getAnimal() {
        return animal;
    }


    public Person getPerson() {
        return person;
    }
}
