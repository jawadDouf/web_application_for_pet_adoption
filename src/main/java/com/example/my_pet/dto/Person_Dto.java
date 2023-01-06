package com.example.my_pet.dto;



import com.example.my_pet.model.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


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



    //Create to dto method
    public Person_Dto to_dto(Person person){

        //Prepare Animals kept


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
