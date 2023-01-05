package com.example.my_pet.dto;

import com.example.my_pet.model.entities.Animal;
import com.example.my_pet.model.enums.Animal_Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class Animal_Dto {


    private int id;
    private String name;
    private int age;
    private String description;
    private boolean status;
    private int originalOwnerId;
    private Animal_Type type;

    public  Animal_Dto to_dto(Animal animal){

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