package com.example.my_pet.dto;


import lombok.Builder;
import lombok.Data;

@Data
public class Login_Dto {
    private String email;

    private String password;
}
