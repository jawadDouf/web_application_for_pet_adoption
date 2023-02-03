package com.example.my_pet.services;

import com.example.my_pet.dto.PersonDto;
import com.example.my_pet.model.entities.Person;
import com.example.my_pet.exceptions.NotFoundException;
import com.example.my_pet.repositories.Person_Repo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private Person_Repo personRepo;

    private PersonDto personDto;

    public PersonService(Person_Repo personRepo, PersonDto personDto) {
        this.personRepo = personRepo;
        this.personDto = personDto;
    }

    //get a person by id
    public PersonDto getPersonById(int id){
        //Get the person
        Optional<Person> person = personRepo.findById(id);
        //Check if the person is present
        if(person.isPresent()){
            //Return the person
            return personDto.to_dto(person.get());
        }else{
            //Throw an exception
            throw new NotFoundException("There is no person with this id");
        }
    }
}
