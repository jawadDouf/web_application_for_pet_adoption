package com.example.my_pet.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "comments")


@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String body;

    @Column(name = "person_id")
     private long personId;

    @Column(name = "publicationId")
    private long publicationId;

    @ManyToOne
    @JoinColumn(name = "person_id", insertable = false, updatable = false)

    private Person person;


    @ManyToOne
    @JoinColumn(name = "publicationId" , insertable = false,updatable = false)

    private Publication publication;

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }


    public long getPersonId() {
        return personId;
    }


    public long getPublicationId() {
        return publicationId;
    }

    @JsonBackReference
    public Person getPerson() {
        return person;
    }

    @JsonBackReference
    public Publication getPublication() {
        return publication;
    }
}
