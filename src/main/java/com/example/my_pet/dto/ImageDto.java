package com.example.my_pet.dto;


import com.example.my_pet.model.entities.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Builder
@Data
@Component
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {

    private String name;

    private String type;


    public ImageDto to_dto(Image image){

        return ImageDto.builder()
                .name(image.getName())
                .type(image.getType())
                .build();
    }
}
