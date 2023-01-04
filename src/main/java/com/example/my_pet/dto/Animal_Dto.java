package com.example.my_pet.dto;

import com.example.my_pet.entities.Animal;
import com.example.my_pet.entities.enums.Animal_Type;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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
    private int originalOwnerId;
    private Animal_Type type;

    public static Animal_Dto to_dto(Animal animal){

        return Animal_Dto.builder()
                         .id(animal.getId())
                          .age(animal.getAge())
                          .description(animal.getDescription())
                        .originalOwnerId(animal.getOriginalOwnerId())
                        .name(animal.getName())
                         .type(animal.getType())
                        .status(animal.isStatus()).build();

    }

}
