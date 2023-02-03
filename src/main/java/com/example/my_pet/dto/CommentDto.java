package com.example.my_pet.dto;

import com.example.my_pet.model.entities.Comment;
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
public class CommentDto {

    private int id;
    private String body;
    private PersonDto person_dto;

    private List<ReplyDto> replies;


    public CommentDto to_Dto(Comment comment){
        //Prepare the replies => turn replies to replies_dto
        List<ReplyDto> replyDtos = comment.getReplies()
                .stream()
                .map(reply-> new ReplyDto().to_dto(reply))
                .collect(Collectors.toList());
        //Return the dto
        return CommentDto.builder()
                .id(comment.getId())
                .body(comment.getBody())
                .person_dto(new PersonDto().to_dto(comment.getPerson()))
                .replies(replyDtos)
                .build();
    }
}
