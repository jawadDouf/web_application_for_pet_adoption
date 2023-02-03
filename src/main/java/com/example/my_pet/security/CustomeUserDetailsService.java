package com.example.my_pet.security;

import com.example.my_pet.model.entities.Person;
import com.example.my_pet.model.entities.Roles;
import com.example.my_pet.repositories.Person_Repo;
import com.example.my_pet.repositories.Role_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomeUserDetailsService implements UserDetailsService {

    private  Person_Repo personRepo;
    private Role_Repo roleRepository;


    public CustomeUserDetailsService(Person_Repo personRepo, Role_Repo roleRepository) {
        this.personRepo = personRepo;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = personRepo.findByEmail(email);
        return new User(person.getEmail(),person.getPassword(),mapRolesToAuthorities(person.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Roles> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
