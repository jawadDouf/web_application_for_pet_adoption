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
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String body;

    @Column(name = "person_id")
     private int personId;

    @Column(name = "publicationId")
    private int publicationId;

    @ManyToOne
    @JoinColumn(name = "person_id",insertable = false,updatable = false)
    private Person person;


    @OneToMany(mappedBy = "comment")
    private List<Reply> replies;

    @ManyToOne
    @JoinColumn(name = "publicationId",insertable = false,updatable = false)
    private Publication publication;


}
