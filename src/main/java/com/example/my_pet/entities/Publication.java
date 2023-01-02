package com.example.my_pet.entities;

import com.example.my_pet.entities.enums.Animal_Type;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;



@Entity
@Table(name="publications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false,columnDefinition = "varchar(40)")
    private String person_name;

    @Column(nullable = false,columnDefinition = "varchar(255)")
    private String person_email;

    @Column(nullable = false,columnDefinition = "varchar(20)")
    private String person_phone_number;

    @Column(nullable = false,columnDefinition = "varchar(40)")
    private String person_adresse;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,columnDefinition = "varchar(255)")
    private Animal_Type animal_type;

    @Column(nullable = false,columnDefinition = "varchar(500)")
    private String animal_description;

    @Column(nullable = false,columnDefinition = "varchar(500)")
    private String publication_description;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Animal animal;

    @OneToMany(mappedBy = "publication")
    private List<Comment> comments;
}
