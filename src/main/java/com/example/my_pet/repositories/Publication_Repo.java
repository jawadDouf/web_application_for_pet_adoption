package com.example.my_pet.repositories;

import com.example.my_pet.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Publication_Repo extends JpaRepository<Publication,Integer> {
}
