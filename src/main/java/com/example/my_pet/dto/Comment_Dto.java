package com.example.my_pet.dto;

import com.example.my_pet.model.entities.Comment;
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
public class Comment_Dto {

    private int id;
    private String body;
    private Person_Dto person_dto;



    public Comment_Dto to_Dto(Comment comment){
        //Set the person who wrote the comment
        /*
        Person person1 = new Person();
        person1.setId(comment.getPerson().getId());
        person1.setFirst_name(comment.getPerson().getFirst_name());
        person1.setLast_name(comment.getPerson().getLast_name());

         */
        //Return the dto
        return Comment_Dto.builder()
                .id(comment.getId())
                .body(comment.getBody())
                .person_dto(new Person_Dto().to_dto(comment.getPerson()))
                .build();
    }
}
