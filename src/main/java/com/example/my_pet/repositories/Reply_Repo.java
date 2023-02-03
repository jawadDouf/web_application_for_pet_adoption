package com.example.my_pet.repositories;

import com.example.my_pet.model.entities.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Reply_Repo extends JpaRepository<Reply,Integer> {

}
