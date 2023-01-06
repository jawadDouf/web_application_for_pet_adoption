package com.example.my_pet.dto;

import com.example.my_pet.model.entities.Comment;
import com.example.my_pet.model.entities.Person;
import com.example.my_pet.model.entities.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class Comment_Dto {

    private int id;
    private String body;
    private Person_Dto person_dto;

    private List<Reply_Dto> replies;


    public Comment_Dto to_Dto(Comment comment){
        //Prepare the replies => turn replies to replies_dto
        List<Reply_Dto> replyDtos = comment.getReplies()
                .stream()
                .map(reply-> new Reply_Dto().to_dto(reply))
                .collect(Collectors.toList());
        //Return the dto
        return Comment_Dto.builder()
                .id(comment.getId())
                .body(comment.getBody())
                .person_dto(new Person_Dto().to_dto(comment.getPerson()))
                .replies(replyDtos)
                .build();
    }
}
