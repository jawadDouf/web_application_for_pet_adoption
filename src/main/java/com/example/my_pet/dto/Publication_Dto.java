package com.example.my_pet.dto;


import com.example.my_pet.entities.Animal;
import com.example.my_pet.entities.Person;
import com.example.my_pet.entities.Publication;
import com.example.my_pet.entities.enums.Animal_Type;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class Publication_Dto {

    private int id;

    private String person_name;

    private String person_email;

    private String person_phone_number;

    private String person_adresse;

    private Animal_Type animal_type;

    private String animal_description;

    private String publication_description;

    public Publication_Dto to_dto(Publication publication, Person person, Animal animal){

        return Publication_Dto.builder().id(publication.getId())
                .animal_description(animal.getDescription())
                .animal_type(animal.getType())
                .person_email(person.getEmail())
                .person_name(person.getLast_name() + " " + person.getFirst_name())
                .person_phone_number(person.getPhone_number())
                .publication_description(publication.getPublication_description())
                .person_adresse(person.getAdresse()).build();
    }
}
