package com.example.my_pet.controllers;

import com.example.my_pet.dto.Comment_Dto;
import com.example.my_pet.exceptions.BadRequestException;
import com.example.my_pet.model.entities.Comment;
import com.example.my_pet.services.Comment_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/comments")
public class Comment_Controller {

    private Comment_Service commentService;

    public Comment_Controller(Comment_Service commentService) {
        this.commentService = commentService;
    }
    //Get all comments by publication id
    @GetMapping("/{id}")
    public ResponseEntity<List<Comment_Dto>> getAllCommentsByPublicationId(@PathVariable int id){
        try {
            return new ResponseEntity<>(commentService.getAllCommentsByPublicationId(id),HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("There is no comments with this id");
        }
    }

    //Create Comment
    @PostMapping()
    public ResponseEntity<String> createComment(@RequestBody Comment comment){
        try {
            //Create the comment => Add the comment ot the database
            commentService.save(comment);
            //Return the response
            return new ResponseEntity<>("Comment is created",HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("Something wrong with the syntax,type or form of data you entered");
        }
    }
}
