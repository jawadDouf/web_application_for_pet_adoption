package com.example.my_pet.repositories;

import com.example.my_pet.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Animal_Repo extends JpaRepository<Animal,Integer> {



}