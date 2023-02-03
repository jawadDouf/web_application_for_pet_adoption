package com.example.my_pet.dto;

import com.example.my_pet.model.entities.Animal_Keeper;
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
public class AnimalKeeperDto {

    private int id;

    private PersonDto person;

    public AnimalKeeperDto to_dto(Animal_Keeper animalKeeper){

        return AnimalKeeperDto.builder()
                .id(animalKeeper.getId())
                .person(new PersonDto().to_dto(animalKeeper.getPerson()))
                .build();
    }

}

