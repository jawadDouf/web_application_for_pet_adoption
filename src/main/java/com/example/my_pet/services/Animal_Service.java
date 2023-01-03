package com.example.my_pet.services;


import com.example.my_pet.entities.Animal;
import com.example.my_pet.exceptions.NotFoundException;
import com.example.my_pet.repositories.Animal_Repo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        animal1.setType(animal1.getType());

        return animal1;
    }


    //Gett all animals of a user
    public List<Animal> getAllAnimalsById(int id){
        return animalRepo.getAllByOriginal_owner_id(id);
    }

}