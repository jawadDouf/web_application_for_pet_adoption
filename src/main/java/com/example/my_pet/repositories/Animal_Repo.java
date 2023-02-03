package com.example.my_pet.repositories;

import com.example.my_pet.model.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Animal_Repo extends JpaRepository<Animal,Integer> {


    void deleteById(int id);

    List<Animal> getAllByOriginalOwnerId(int id);

    //Get the last inserted animal
    Animal findFirstByOrderByIdDesc();


}
