package com.example.my_pet.dto;


import com.example.my_pet.model.entities.Animal;
import com.example.my_pet.model.entities.Person;
import com.example.my_pet.model.entities.Publication;
import com.example.my_pet.model.enums.Animal_Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@Component
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDto {


    private int id;

    private String person_name;

    private String person_email;

    private String person_phone_number;

    private String person_adresse;

    private Animal_Type animal_type;

    private String animal_description;

    private String publication_description;

    private LocalDate start_date;

    private LocalDate end_date;
    private int person_id;

    private int animal_id;
    private List<CommentDto> comments_dtos;





    public PublicationDto to_dto(Publication publication, Person person, Animal animal){
        //Bring the comments and turns the to dtos
        List<CommentDto> commentDs =  publication
                .getComments()
                .stream()
                .map(comment -> new CommentDto().to_Dto(comment)).collect(Collectors.toList());

        //Return the publications
        return PublicationDto.builder().id(publication.getId())
                .animal_description(animal.getDescription())
                .animal_type(animal.getType())
                .person_email(person.getEmail())
                .person_name(person.getLast_name() + " " + person.getFirst_name())
                .person_phone_number(person.getPhone_number())
                .publication_description(publication.getPublication_description())
                .person_adresse(person.getAdresse())
                .start_date(publication.getStart_date())
                .end_date(publication.getEnd_date())
                .person_id(person.getId())
                .animal_id(animal.getId())
              .comments_dtos(commentDs)
                .build();
    }
}
