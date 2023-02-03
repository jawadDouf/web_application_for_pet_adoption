package com.example.my_pet.services;

import com.example.my_pet.dto.ImageDto;
import com.example.my_pet.model.entities.Animal;
import com.example.my_pet.model.entities.Image;
import com.example.my_pet.repositories.Image_Repo;
import com.example.my_pet.utils.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ImageDataService {

    private Image_Repo imageDataRepository;

    private ImageDto imageDto;
    public ImageDataService(Image_Repo imageDataRepository, ImageDto imageDto) {
        this.imageDataRepository = imageDataRepository;
        this.imageDto = imageDto;
    }

    //Create an image
    public Image save(Image image) {
        return imageDataRepository.save(image);
    }

    //Find images by PersonId
    public List<Image> getImagesByPersonId(int id){
        return imageDataRepository.findByPersonId(id);
    }

    public List<ImageDto> getImageByAnimalId(int id){

        return imageDataRepository.findAllByAnimalId(id).stream().map(imageDto::to_dto).collect(Collectors.toList());
    }



}
