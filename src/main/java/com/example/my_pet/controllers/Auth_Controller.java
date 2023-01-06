package com.example.my_pet.controllers;

import com.example.my_pet.dto.Auth_Response_Dto;
import com.example.my_pet.dto.Login_Dto;
import com.example.my_pet.dto.Register_Dto;
import com.example.my_pet.model.entities.Person;
import com.example.my_pet.model.entities.Roles;
import com.example.my_pet.repositories.Person_Repo;
import com.example.my_pet.repositories.Role_Repo;
import com.example.my_pet.security.JWTGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("api/authentification")
public class Auth_Controller {

    private AuthenticationManager authenticationManager;
    private  Person_Repo personRepo;
    private Role_Repo roleRepo;
    private  PasswordEncoder passwordEncoder;
    private  JWTGenerator jwtGenerator;


    public Auth_Controller(AuthenticationManager authenticationManager, Person_Repo personRepo, Role_Repo roleRepo, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.personRepo = personRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;

    }



    @PostMapping("/login")
    public ResponseEntity<Auth_Response_Dto> login(@RequestBody Login_Dto loginDto){
        System.out.println("p");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        System.out.println("e");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("n");
        String token = jwtGenerator.generateToken(authentication);
        System.out.println("bxx :" + token);
        return new ResponseEntity<>(new Auth_Response_Dto(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Register_Dto registerDto){
        if(personRepo.existsByEmail(registerDto.getEmail())){
            return new ResponseEntity<>("Email is taken", HttpStatus.BAD_REQUEST);
        }

        Person person = new Person();
        person.setEmail(registerDto.getEmail().toLowerCase());
        person.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        person.setLast_name(registerDto.getLast_name());
        person.setFirst_name(registerDto.getFirst_name());
        person.setPhone_number(registerDto.getPhone_number());
        person.setAdresse(registerDto.getAdresse());
        Roles role = roleRepo.findByName("User").get();
        person.setRoles(Collections.singletonList(role));
        personRepo.save(person);
        return new ResponseEntity<>("User registred success",HttpStatus.OK);
    }
}
