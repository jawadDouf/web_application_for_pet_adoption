package com.example.my_pet.dto;


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

    public Publication_Dto to_dto(Publication publication){

        return Publication_Dto.builder().id(publication.getId())
                .animal_description(publication.getAnimal_description())
                .animal_type(publication.getAnimal_type())
                .person_email(publication.getPerson_email())
                .person_name(publication.getPerson_name())
                .person_phone_number(publication.getPerson_phone_number())
                .publication_description(publication.getPublication_description())
                .person_adresse(publication.getPerson_adresse()).build();
    }
}
