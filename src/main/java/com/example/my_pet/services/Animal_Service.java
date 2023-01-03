package com.example.my_pet.services;


import com.example.my_pet.entities.Animal;
import com.example.my_pet.repositories.Animal_Repo;
import org.springframework.stereotype.Service;

@Service
public class Animal_Service {

    private Animal_Repo animalRepo;

    public Animal_Service(Animal_Repo animalRepo) {
        this.animalRepo = animalRepo;
    }

    //Create Animal
    public Animal save(Animal animal) {
         return animalRepo.save(animal);
    }

}