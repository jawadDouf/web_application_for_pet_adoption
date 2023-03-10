package com.example.my_pet.controllers;

import com.example.my_pet.dto.PublicationDto;
import com.example.my_pet.model.entities.Publication;
import com.example.my_pet.exceptions.BadRequestException;
import com.example.my_pet.services.PublicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/publications")
@CrossOrigin(origins="http://localhost:4200")
public class PublicationController {

    private PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    //Get all publications
    @GetMapping()
    public ResponseEntity<List<PublicationDto>> getAllPublications(){
        try {
            return new ResponseEntity<>(publicationService.getAllPublication(), HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("your request syntax is wrong");
        }
    }



    //Create a publication

    @PostMapping()
    public ResponseEntity<String> createPublication(@RequestBody Publication publication){
        try {
            publicationService.createPublication(publication);
            return new ResponseEntity<>("Publication is created",HttpStatus.CREATED);
        }catch (Exception e){
            throw new BadRequestException("Something wrong in the form of the data you entered");
        }
    }

    //Get one publication by id

    @GetMapping("one/{id}")
    public ResponseEntity<PublicationDto> getOnePublication(@PathVariable int id){
            return new ResponseEntity<>(publicationService.getPublicationById(id),HttpStatus.OK);

    }

    //Delete one publication by id
    @DeleteMapping ("one/{id}")
    public ResponseEntity<String> deletePublication(@PathVariable int id){
        try {
            publicationService.deletePublication(id);
            return new ResponseEntity<>("Publication is deleted",HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("There is no publication with this id");
        }
    }

    //Update one publication by id
    @PutMapping("one/{id}")
    public ResponseEntity<String> updatePublication(@PathVariable int id, @RequestBody Publication publication){
        try {
            publicationService.updatePublication(publication,id);
            return new ResponseEntity<>("Publication is updated",HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("There is no publication with this id");
        }
    }

    //Get all publications by animal id
    @GetMapping("animal/{id}")
    public ResponseEntity<List<PublicationDto>> getAllPublicationByAnimalId(@PathVariable int id){
        try {
            return new ResponseEntity<>(publicationService.getAllPublicationByAnimal(id),HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("There is no publications with this animal id");
        }
    }

    //Get all publications by person id
    @GetMapping("person/{id}")
    public ResponseEntity<List<PublicationDto>> getAllPublicationByPersonId(@PathVariable int id){
        try {
            return new ResponseEntity<>(publicationService.getAllPublicationByPerson(id),HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("There is no publications with this person id");
        }
    }

}
