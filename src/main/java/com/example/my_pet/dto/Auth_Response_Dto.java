package com.example.my_pet.dto;

import lombok.Builder;
import lombok.Data;


@Data
public class Auth_Response_Dto{

    private String accessToken;
    private String tokenType ="Bearer ";

    public Auth_Response_Dto(String accessToken){

        this.accessToken=accessToken;
    }




}
