package com.example.my_pet.model.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jbosslog.JBossLog;

import java.sql.Blob;

@Entity
@Table(name = "imageData")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    private String name;

    private String type;




    @OneToOne
    @JoinColumn(name = "personId",insertable = false,updatable = false)
    private Person person;

    @Column(name="personId")
    private int personId;

    @ManyToOne
    @JoinColumn(name = "animalId",insertable = false,updatable = false)
    private Animal animal;

    @Column(name = "animalId")
    private int animalId;



}
