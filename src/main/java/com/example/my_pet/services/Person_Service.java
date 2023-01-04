package com.example.my_pet.services;

import com.example.my_pet.entities.Person;
import com.example.my_pet.exceptions.NotFoundException;
import com.example.my_pet.repositories.Person_Repo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Person_Service {

    private Person_Repo personRepo;

    public Person_Service(Person_Repo personRepo) {
        this.personRepo = personRepo;
    }

    //get a person by id
    public Person getPersonById(int id){
        //Get the person
        Optional<Person> person = personRepo.findById(id);
        //Check if the person is present
        if(person.isPresent()){
            //Return the person
            return person.get();
        }else{
            //Throw an exception
            throw new NotFoundException("There is no person with this id");
        }
    }
}
