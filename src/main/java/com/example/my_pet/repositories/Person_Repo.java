package com.example.my_pet.repositories;

import com.example.my_pet.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Person_Repo extends JpaRepository<Person, Integer> {
    Person findByEmail(String email);

}
