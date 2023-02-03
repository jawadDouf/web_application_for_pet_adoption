package com.example.my_pet.controllers;

import com.example.my_pet.dto.CommentDto;
import com.example.my_pet.exceptions.BadRequestException;
import com.example.my_pet.model.entities.Comment;
import com.example.my_pet.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/comments")
@CrossOrigin(origins = "http://localhost:4200" ,allowedHeaders = "*")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    //Get all comments by publication id
    @GetMapping("/{id}")
    public ResponseEntity<List<CommentDto>> getAllCommentsByPublicationId(@PathVariable int id){
        try {
            return new ResponseEntity<>(commentService.getAllCommentsByPublicationId(id),HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("There is no comments with this id");
        }
    }

    //Create Comment
    @PostMapping("/add")
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

    //Get the last inserted comment
    @GetMapping("/last")
    public ResponseEntity<CommentDto> getLastComment(){
        try {
            return new ResponseEntity<>(commentService.getLastComment(),HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("There is no comments");
        }
    }
}
