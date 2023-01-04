package com.example.my_pet.services;

import com.example.my_pet.dto.Publication_Dto;
import com.example.my_pet.entities.Animal;
import com.example.my_pet.entities.Publication;
import com.example.my_pet.exceptions.NotFoundException;
import com.example.my_pet.repositories.Publication_Repo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Publication_Service {

    private Publication_Repo publicationRepo;

    private Publication_Dto publicationDto;



    public Publication_Service(Publication_Repo publicationRepo, Publication_Dto publicationDto) {
        this.publicationRepo = publicationRepo;
        this.publicationDto = publicationDto;

    }
    //get all publications
    public List<Publication_Dto> getAllPublication(){
        //bring all the publication
        List<Publication> publications = publicationRepo.findAll();
        //Turn Publication to dto publication
        List<Publication_Dto> publicationDtos = publications
                .stream()
                .map(
                        pub -> publicationDto.to_dto(pub,pub.getPerson(),pub.getAnimal()))
                .collect(Collectors.toList());
        //Return the publications dtos
        return publicationDtos;
    }

    //Create a publication
    public Publication createPublication(Publication publication){
        return publicationRepo.save(publication);
    }

    //Get a publication by id
    public Publication_Dto getPublicationById(int id){
        //Get the publication
        Optional<Publication> publication = publicationRepo.findById(id);
        //Check if the publication is present
        if(publication.isPresent()) {
            //Turn the publication to dto publication
            Publication_Dto publication_dto = publicationDto.to_dto(publication.get(), publication.get().getPerson(), publication.get().getAnimal());
            //Return the publication
            return publication_dto;
        }else{
            throw new NotFoundException("There is no publication with this id");
        }

    }

    //Detete a publication
    public void deletePublication(int id){
        publicationRepo.deleteById(id);
    }

    //Update a publication
    public Publication_Dto updatePublication(Publication publication, int id){
        //Get the publication
        Optional<Publication> publication1 = publicationRepo.findById(id);
        //Check if the publication is present
        if(publication1.isPresent()) {
            //Update the publication
            publication1.get().setAnimal(publication.getAnimal());
            publication1.get().setPerson(publication.getPerson());
            publication1.get().setStart_date(publication.getStart_date());
            publication1.get().setEnd_date(publication.getEnd_date());
            publication1.get().setPublication_description(publication.getPublication_description());
            //Save the publication
            Publication publication2 = publicationRepo.save(publication1.get());
            //Turn the publication to dto publication
            Publication_Dto publication_dto = publicationDto.to_dto(publication2, publication2.getPerson(), publication2.getAnimal());
            //Return the publication
            return publication_dto;
        }else{
            throw new NotFoundException("There is no publication with this id");
        }

    }

    //Get all publications of an animal
    public List<Publication_Dto> getAllPublicationByAnimal(int id){
        //Get all the publications
        List<Publication> publications = publicationRepo.getAllByAnimalId(id);
        //Turn the publications to dto publications
        List<Publication_Dto> publicationDtos = publications
                .stream()
                .map(pub -> publicationDto.to_dto(pub,pub.getPerson(),pub.getAnimal()))
                .collect(Collectors.toList());
        //Return the publications
        return publicationDtos;
    }

    //Get all publications of a person
    public List<Publication_Dto> getAllPublicationByPerson(int id){
        //Get all the publications
        List<Publication> publications = publicationRepo.getAllByPersonId(id);
        //Turn the publications to dto publications
        List<Publication_Dto> publicationDtos = publications
                .stream()
                .map(pub -> publicationDto.to_dto(pub,pub.getPerson(),pub.getAnimal()))
                .collect(Collectors.toList());
        //Return the publications
        return publicationDtos;
    }

}
