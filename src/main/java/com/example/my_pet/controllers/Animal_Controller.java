package com.example.my_pet.controllers;

import com.example.my_pet.dto.Animal_Dto;
import com.example.my_pet.model.entities.Animal;
import com.example.my_pet.exceptions.BadRequestException;
import com.example.my_pet.exceptions.NotFoundException;
import com.example.my_pet.services.Animal_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class Animal_Controller {

    private Animal_Service animalService;

    public Animal_Controller(Animal_Service animalService
                            ){
        this.animalService = animalService;

    }

    //Create Animal
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
    //Return one animal by id
    @GetMapping("/one/{id}")
    public ResponseEntity<Animal_Dto> getOneAnimal(@PathVariable int id){
            //Bring the element and turn it to dto
            return new ResponseEntity<>(animalService.getAnimalById(id),HttpStatus.OK);
    }

    //Delete Element by id
    @DeleteMapping("/one/{id}")
    public ResponseEntity<String> deleteElement(@PathVariable int id){
        try {
            //Delete the element
            animalService.deleteAnimal(id);
            //Return the response
            return new ResponseEntity<>("Animal is deleted",HttpStatus.OK);
        }catch (Exception e){
            //Return error message
            throw new NotFoundException("There is no animal with this id");
        }
    }

    //Update element by id
    @PutMapping("/one/{id}")
    public ResponseEntity<Animal_Dto> updateAnimal(@RequestBody Animal animal,@PathVariable int id){
        try {
            //Update the element
           return new ResponseEntity<>(animalService.updateAnimal(animal,id),HttpStatus.CREATED);
        }catch (Exception e){
            throw new BadRequestException("Something wrong in the form of the data you entered");
        }
    }

    @GetMapping("/myAnimals/{id}")
    public ResponseEntity<List<Animal_Dto>> getAllAnimalOfUser(@PathVariable int id){

        try{
            //get all the elements of specific user
            return new ResponseEntity<>(animalService.getAllAnimalsById(id),HttpStatus.OK);
        }catch (Exception e){
            throw new NotFoundException("There is no user with this id");
        }
    }


}
