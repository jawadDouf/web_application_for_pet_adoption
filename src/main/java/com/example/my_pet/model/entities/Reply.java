package com.example.my_pet.model.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Table(name = "replies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Reply implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment_reply",nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "comment_id",insertable = false,updatable = false)
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "person_id",insertable = false,updatable = false)
    private Person person;

    @Column(name = "person_id")
    private int personId;

    @Column(name = "comment_id")
    private int commentId;


}
