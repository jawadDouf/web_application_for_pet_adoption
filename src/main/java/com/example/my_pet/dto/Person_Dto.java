package com.example.my_pet.dto;


import com.example.my_pet.model.entities.Animal_Keeper;
import com.example.my_pet.model.entities.Person;
import com.example.my_pet.model.entities.Publication;
import com.example.my_pet.services.Animal_Service;
import com.example.my_pet.services.Publication_Service;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@Component
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
public class Person_Dto {


    private int id;
    private String first_name;

    private String last_name;


    private String email;


    private String password;


    private String adresse;


    private String phone_number;

    private List<Animal_Keeper_Dto> animals_kept;

    //Create to dto method
    public Person_Dto to_dto(Person person){



        //Return the person and its animals
        return Person_Dto.builder()
                .id(person.getId())
                .first_name(person.getFirst_name())
                .last_name(person.getLast_name())
                .email(person.getEmail())
                .password(person.getPassword())
                .adresse(person.getAdresse())
                .phone_number(person.getPhone_number())
                .build();
    }

}
