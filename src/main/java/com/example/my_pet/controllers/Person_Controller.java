package com.example.my_pet.controllers;


import com.example.my_pet.dto.Person_Dto;
import com.example.my_pet.services.Person_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class Person_Controller {

    private Person_Service personService;


    public Person_Controller(Person_Service personService) {
        this.personService = personService;

    }


    //Get Person By Id
    @GetMapping("/{id}")
    public ResponseEntity<Person_Dto> getPersonByd(@PathVariable int id){
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }
}
