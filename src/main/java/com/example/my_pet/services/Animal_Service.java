package com.example.my_pet.services;


import com.example.my_pet.dto.Animal_Dto;
import com.example.my_pet.entities.Animal;
import com.example.my_pet.exceptions.NotFoundException;
import com.example.my_pet.repositories.Animal_Repo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    //Get Animal by id
    public Animal getAnimalById(int id){
        Optional<Animal> animal = animalRepo.findById(id);
        if(animal.isPresent()){
            return animal.get();
        }else{
            throw new NotFoundException("There is no animal with this id");
        }
    }

    //Delete an element
    public void deleteAnimal(int id){
         animalRepo.deleteById(id);
    }

    //update animal
    public Animal updateAnimal(Animal animal,int id){
        //Get the element
        Animal animal1 = this.getAnimalById(id);
        //update the element
        animal1.setAge(animal.getAge());
        animal1.setName(animal.getName());
        animal1.setDescription(animal.getDescription());
        animal1.setType(animal.getType());
        animal1.setOriginalOwnerId(animal.getOriginalOwnerId());
        //Save the animal
        return this.save(animal1);
    }


    //Get all animals of a user

    public List<Animal_Dto> getAllAnimalsById(int id){
        //Get the animals
        List<Animal> animals = animalRepo.getAllByOriginalOwnerId(id);
        //transfer this animals to dto_animal
        List<Animal_Dto> animalsdto =  animals.stream().map(animal ->
            Animal_Dto.to_dto(animal)
        ).collect(Collectors.toList());
        return animalsdto;
    }

}