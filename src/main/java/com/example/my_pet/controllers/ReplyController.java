package com.example.my_pet.controllers;


import com.example.my_pet.exceptions.BadRequestException;
import com.example.my_pet.model.entities.Reply;
import com.example.my_pet.services.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/replies")
@CrossOrigin(origins = "http://localhost:4200" ,allowedHeaders = "*")
public class ReplyController {


    private ReplyService replyService;

    public ReplyController(ReplyService replyService) {

        this.replyService = replyService;
    }

    @PostMapping()
    public ResponseEntity<String> saveReply(@RequestBody Reply reply){
        try {
            replyService.save(reply);
            return new ResponseEntity<>("Reply is created", HttpStatus.CREATED);
        }catch (Exception e){
            throw new BadRequestException("Something wrong in the form of the data you entered");
        }
    }
}
