package com.example.my_pet.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Register_Dto {
    private int id;
    private String email;

    private String password;




    private String first_name;


    private String last_name;



    private String adresse;


    private String phone_number;

}
