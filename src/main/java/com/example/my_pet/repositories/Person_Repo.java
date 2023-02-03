package com.example.my_pet.repositories;

import com.example.my_pet.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Person_Repo extends JpaRepository<Person, Integer> {

    Person findByEmail(String email);
    Boolean existsByEmail(String email);

}
