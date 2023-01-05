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
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class Comment_Dto {

    private int id;
    private String body;

    private Person person;



    public Comment_Dto to_Dto(Comment comment){
        return Comment_Dto.builder()
                .id(comment.getId())
                .body(comment.getBody())
                .person(comment.getPerson())
                .build();
    }
}
