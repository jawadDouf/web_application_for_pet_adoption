package com.example.my_pet.controllers;


import com.example.my_pet.dto.PersonDto;
import com.example.my_pet.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
@CrossOrigin(origins="http://localhost:4200")
public class PersonController {

    private PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;

    }


    //Get Person By Id
    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonByd(@PathVariable int id){
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }
}
