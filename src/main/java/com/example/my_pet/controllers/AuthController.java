package com.example.my_pet.controllers;

import com.example.my_pet.dto.AuthResponseDto;
import com.example.my_pet.dto.LoginDto;
import com.example.my_pet.dto.RegisterDto;
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
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("api/authentification")
@CrossOrigin(origins="http://localhost:4200")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private  Person_Repo personRepo;
    private Role_Repo roleRepo;
    private  PasswordEncoder passwordEncoder;
    private  JWTGenerator jwtGenerator;


    public AuthController(AuthenticationManager authenticationManager, Person_Repo personRepo, Role_Repo roleRepo, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.personRepo = personRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;

    }



    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDto(token,personRepo.findByEmail(loginDto.getEmail()).getId()), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
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
