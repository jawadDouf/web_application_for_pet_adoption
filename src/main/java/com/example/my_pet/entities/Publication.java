package com.example.my_pet.entities;

import com.example.my_pet.entities.enums.Animal_Type;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;



@Entity
@Table(name="publications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne
    @JoinColumn(name="personId")
    private Person person;

    @ManyToOne
    @JoinColumn(name="animalId")
    private Animal animal;

    @OneToMany(mappedBy = "publication")
    private List<Comment> comments;


}
