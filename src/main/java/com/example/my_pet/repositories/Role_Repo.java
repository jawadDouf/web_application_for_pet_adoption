package com.example.my_pet.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.Optional;

@Repository
public interface Role_Repo extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
