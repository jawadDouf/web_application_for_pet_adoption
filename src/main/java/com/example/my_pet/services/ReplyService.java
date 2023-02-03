package com.example.my_pet.services;


import com.example.my_pet.model.entities.Reply;
import com.example.my_pet.repositories.Reply_Repo;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    private Reply_Repo replyRepo;

    public ReplyService(Reply_Repo replyRepo) {
        this.replyRepo = replyRepo;
    }

    //Save a reply in the database
    public Reply save(Reply reply){
        System.out.println("Reply_Service.save");
        return replyRepo.save(reply);
    }
}
