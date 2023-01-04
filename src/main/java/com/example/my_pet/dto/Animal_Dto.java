package com.example.my_pet.dto;

import com.example.my_pet.entities.Animal;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal_Dto {


    private int id;
    private String name;
    private int age;
    private String description;
    private boolean status;
    private int original_owner_id;

    public static Animal_Dto to_dto(Animal animal){

        return Animal_Dto.builder()
                         .id(animal.getId())
                          .age(animal.getAge())
                          .description(animal.getDescription())
                        .original_owner_id(animal.getOriginal_owner_id())
                        .name(animal.getName())
                        .status(animal.isStatus()).build();

    }

}
