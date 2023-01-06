package com.example.my_pet.model.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinColumn(name = "userId")
    private List<Person> persons;
}
