package com.example.my_pet.dto;

import com.example.my_pet.model.entities.Animal;
import com.example.my_pet.model.entities.Animal_Keeper;
import com.example.my_pet.model.entities.Person;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class Animal_Keeper_Dto {

    private int id;

    private Person_Dto person;

    public Animal_Keeper_Dto to_dto(Animal_Keeper animalKeeper){

        return Animal_Keeper_Dto.builder()
                .id(animalKeeper.getId())
                .person(new Person_Dto().to_dto(animalKeeper.getPerson()))
                .build();
    }

}

