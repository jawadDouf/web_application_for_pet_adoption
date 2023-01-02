package com.example.my_pet.entities;


import com.example.my_pet.entities.enums.Animal_Type;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "animals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal implements Serializable {



    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "animal_id", nullable = false)
    private int id;

    @Column(columnDefinition = "varchar(50) default 'unknown'")
    private String name;

    @Column(nullable = false,columnDefinition = "integer")
    private int age;

    @Column(columnDefinition = "varchar(500)")
    private String description;

    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean status;

    @Column(nullable = false,columnDefinition = "integer")
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
