package com.example.my_pet.entities;


import com.example.my_pet.entities.enums.Animal_Type;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "animals")
@Data
public class Animal implements Serializable {



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "animal_id", nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String description;

    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean status;

    @Column(nullable = false)
    private int original_owner_id;

    @ElementCollection
    private List<String> photos;

    @OneToMany(mappedBy = "animal")
    private List<Animal_Keeper> keepers;

    @Enumerated(EnumType.STRING)
    private Animal_Type type;

    @OneToMany(mappedBy = "animal")
    private List<Publication> publications;


}
