package com.example.my_pet.repositories;

import com.example.my_pet.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Person_Repo extends JpaRepository<Person, Integer> {

    Optional<Person> findByEmail(String email);
    Boolean existsByEmail(String email);

}
