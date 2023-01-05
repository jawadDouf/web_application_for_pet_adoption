package com.example.my_pet.repositories;


import com.example.my_pet.model.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Comment_Repo extends JpaRepository<Comment, Integer>{


    List<Comment> getAllByPublicationId(int id);
}
