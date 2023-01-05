package com.example.my_pet.services;


import com.example.my_pet.dto.Comment_Dto;
import com.example.my_pet.model.entities.Comment;
import com.example.my_pet.repositories.Comment_Repo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class Comment_Service {


    private Comment_Repo commentRepo;

    private Comment_Dto commentDto;

    public Comment_Service(Comment_Repo commentRepo, Comment_Dto commentDto) {
        this.commentRepo = commentRepo;
        this.commentDto = commentDto;
    }

    //Get all comments by publication id
    public List<Comment_Dto> getAllCommentsByPublicationId(int id){
        //Get all the comments
        List<Comment> comments = commentRepo.findAllByPublicationId(id);
        for (int i = 0;i<comments.size();i++){
            System.out.println(comments.get(i).getPersonId());
        }
       // return comments;

        //Turn the comments to dto comments
        List<Comment_Dto> commentsDto = comments
                .stream()
                .map(comment->commentDto.to_Dto(comment))
                .collect(Collectors.toList());
        return commentsDto;


    }

    //Create A comment
    public Comment save(Comment comment){
        return commentRepo.save(comment);
    }
}
