package com.example.my_pet.controllers;

import com.example.my_pet.dto.Comment_Dto;
import com.example.my_pet.exceptions.BadRequestException;
import com.example.my_pet.services.Comment_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/comments")
public class Comment_Controller {

    private Comment_Service commentService;

    public Comment_Controller(Comment_Service commentService) {
        this.commentService = commentService;
    }
    //Get all comments by publication id
    @GetMapping("/publication/{id}")
    public ResponseEntity<List<Comment_Dto>> getAllCommentsByPublicationId(@PathVariable int id){
        try {
            return new ResponseEntity<>(commentService.getAllCommentsByPublicationId(id), HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("There is no publication with this id");
        }
    }
}
