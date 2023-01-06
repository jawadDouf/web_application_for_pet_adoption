package com.example.my_pet.dto;

import com.example.my_pet.model.entities.Animal;
import com.example.my_pet.model.entities.Animal_Keeper;
import com.example.my_pet.model.enums.Animal_Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Builder
@Data
@Component
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
public class Animal_Dto {


    private int id;
    private String name;
    private int age;
    private String description;
    private boolean status;
    private int originalOwnerId;
    private Animal_Type type;

    private List<Animal_Keeper_Dto> keepers;

    public  Animal_Dto to_dto(Animal animal){

        //Prepare the keepers of the animal
        List<Animal_Keeper_Dto> keeps = animal.getKeepers()
                .stream()
                .map(k->new Animal_Keeper_Dto().to_dto(k))
                .collect(Collectors.toList());
        //

        return Animal_Dto.builder()
                         .id(animal.getId())
                         .age(animal.getAge())
                         .description(animal.getDescription())
                         .originalOwnerId(animal.getOriginalOwnerId())
                         .name(animal.getName())
                         .type(animal.getType())
                         .keepers(keeps)
                         .status(animal.isStatus())
                         .build();

    }

}
