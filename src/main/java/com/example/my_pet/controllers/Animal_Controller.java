package com.example.my_pet.controllers;

import com.example.my_pet.entities.Animal;
import com.example.my_pet.exceptions.BadRequestException;
import com.example.my_pet.services.Animal_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/animals")
public class Animal_Controller {

    private Animal_Service animalService;

    public Animal_Controller(Animal_Service animalService){
        this.animalService = animalService;
    }

    @PostMapping()
    public ResponseEntity<String> saveAnimal(@RequestBody Animal animal){
        try {
            //create the animal
            animalService.save(animal);
            //return the response
            return new ResponseEntity<>("Animal is created",HttpStatus.CREATED);
        }catch (Exception bre){
            //return the error response
            throw new BadRequestException("Something wrong in the form or values of the required data");
        }

    }
}
