package com.example.my_pet.dto;


import com.example.my_pet.model.entities.Reply;
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
public class ReplyDto {

    private int id;

    private String body;

    private PersonDto person;

    public ReplyDto to_dto(Reply reply){

        return ReplyDto.builder()
                .id(reply.getId())
                .body(reply.getBody())
                .person(new PersonDto().to_dto(reply.getPerson()))
                .build();
    }


}
