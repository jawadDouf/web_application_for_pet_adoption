package com.example.my_pet.controllers;

import com.example.my_pet.dto.AnimalDto;
import com.example.my_pet.dto.ImageDto;
import com.example.my_pet.exceptions.BadRequestException;
import com.example.my_pet.exceptions.NotFoundException;
import com.example.my_pet.model.entities.Image;
import com.example.my_pet.services.ImageDataService;
import com.example.my_pet.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController()
@RequestMapping("/api/files")
@CrossOrigin(origins="http://localhost:4200")
public class ImageController {


    private ImageDataService imageDataService;


    public ImageController(ImageDataService imageDataService) {
        this.imageDataService = imageDataService;

    }

    @PostMapping()
    public ResponseEntity<String> addImage(@RequestBody Image image){

       try {
           //create the animal
           imageDataService.save(image);
           //return the response
           return new ResponseEntity<>("Image is added",HttpStatus.CREATED);
       }catch (Exception bre){
           //return the error response
           throw new BadRequestException("Something wrong in the form or values of the required data");
       }
   }

   @GetMapping("/byperson/{id}")
   public ResponseEntity<List<Image>> getAllImagesOfPerson(@PathVariable int id){
       try{
           //get all the elements of specific user
           return new ResponseEntity<>(imageDataService.getImagesByPersonId(id),HttpStatus.OK);
       }catch (Exception e){
           throw new NotFoundException("There is no user with this id");
       }
   }

    @GetMapping("/byanimal/{id}")
    public ResponseEntity<List<ImageDto>> getAllImagesOfAnimal(@PathVariable int id){

        try{
            //get all the elements of specific user
            return new ResponseEntity<>(imageDataService.getImageByAnimalId(id),HttpStatus.OK);
        }catch (Exception e){
            throw new NotFoundException("There is no animal with this id");
        }
    }

}



