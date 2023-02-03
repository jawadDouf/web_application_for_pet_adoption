package com.example.my_pet.repositories;

import com.example.my_pet.model.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.hibernate.sql.ast.Clause.WHERE;

@Repository
public interface Image_Repo extends JpaRepository<Image,Integer> {



    Optional<Image> findByName(String name);



    //Get Images by person id
    List<Image> findByPersonId(int id);

    //Get Images by animal id
    List<Image> findAllByAnimalId(int id);





}
