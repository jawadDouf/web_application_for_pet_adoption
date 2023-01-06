package com.example.my_pet.dto;


import com.example.my_pet.model.entities.Comment;
import com.example.my_pet.model.entities.Person;
import com.example.my_pet.model.entities.Reply;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@Scope("prototype")
@NoArgsConstructor
@AllArgsConstructor
public class Reply_Dto {

    private int id;

    private String body;

    private Person_Dto person;

    public Reply_Dto to_dto(Reply reply){

        return Reply_Dto.builder()
                .id(reply.getId())
                .body(reply.getBody())
                .person(new Person_Dto().to_dto(reply.getPerson()))
                .build();
    }


}
