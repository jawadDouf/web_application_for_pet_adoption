package com.example.my_pet.repositories;

import com.example.my_pet.model.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Publication_Repo extends JpaRepository<Publication,Integer> {

    //Get all publications of an animal

    List<Publication> getAllByAnimalId(int id);

    //Get all publications of a person
    List<Publication> getAllByPersonId(int id);
}
