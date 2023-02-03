package com.example.my_pet.dto;

import lombok.Data;


@Data
public class AuthResponseDto {

    private String accessToken;
    private String tokenType ="Bearer";

    private int personId;
    public AuthResponseDto(String accessToken,int personId){
        this.accessToken=accessToken;
        this.personId=personId;
    }




}
