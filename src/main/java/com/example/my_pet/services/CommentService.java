package com.example.my_pet.services;


import com.example.my_pet.dto.CommentDto;
import com.example.my_pet.model.entities.Comment;
import com.example.my_pet.repositories.Comment_Repo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CommentService {


    private Comment_Repo commentRepo;

    private CommentDto commentDto;


    public CommentService(Comment_Repo commentRepo, CommentDto commentDto) {
        this.commentRepo = commentRepo;
        this.commentDto = commentDto;

    }

    //Get all comments by publication id
    public List<CommentDto> getAllCommentsByPublicationId(int id){
        //Get all the comments
        List<Comment> comments = commentRepo.findAllByPublicationId(id);



        //Turn the comments to dto comments
        List<CommentDto> commentsDto = comments
                .stream()
                .map(comment->commentDto.to_Dto(comment))
                .collect(Collectors.toList());
        return commentsDto;


    }

    //Create A comment
    public Comment save(Comment comment){
        return commentRepo.save(comment);
    }


    //Get the last inserted comment
    public CommentDto getLastComment(){
        //Get the last inserted comment
        Comment comment = commentRepo.findTopByOrderByIdDesc();
        //Turn the comment to dto comment
        CommentDto commentDto = this.commentDto.to_Dto(comment);

        return commentDto;
    }
}
