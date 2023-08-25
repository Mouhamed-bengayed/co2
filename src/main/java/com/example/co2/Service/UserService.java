package com.example.co2.Service;

import com.example.co2.Dao.RoleRepository;
import com.example.co2.Dao.UserRepository;
import com.example.co2.Dto.RoleName;
import com.example.co2.Entite.Role;
import com.example.co2.Entite.Userco2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;
import java.beans.Encoder;
import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MailSenderService mailSending;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;



    public List<Userco2> getAllUser() {
        return  userRepository.findAll();
    }


    public Userco2 getUserById (Long idProvider){
        return  userRepository.findById(idProvider).orElseThrow(()-> new IllegalArgumentException("Provider ID not Found"));
    }
    public Userco2 deleteUser(Long id){
        Optional<Userco2> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else
        {
            return null;
        }
    }



    public void validInscription(Long id) {
        Optional<Userco2> user=userRepository.findById(id);
        Userco2 user1=user.get();
        String Newligne = System.getProperty("line.separator");
        String url = "http://localhost:4200/auth/verification/" +user1.getToken();
        String body = "Welcom to our platform \n  use this link to verify your account is :" + Newligne + url;
        if(user.isPresent()) {

            user1.setValid(true);
            this.userRepository.save(user1);
            try {
                mailSending.send(user1.getEmail(), "Welcome Provaider", body);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public ResponseEntity<Userco2> registerUser(Userco2 user1) {
        if (userRepository.existsByUsername(user1.getUsername())) {
            return new ResponseEntity<Userco2>(HttpStatus.NOT_FOUND);
        }
        if (userRepository.existsByEmail(user1.getEmail())) {
            return new ResponseEntity<Userco2>(HttpStatus.BAD_REQUEST);
        }
        Userco2 user = new Userco2(user1.getName(), user1.getUsername(), user1.getEmail(), passwordEncoder.encode(user1.getPassword()), false, user1.getAddress(), false);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.ROLE_Employee)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);
        user.setRoles(roles);
        user.setValid(false);
        Userco2 suser = userRepository.save(user);
        if (suser != null) {
            String Newligne = System.getProperty("line.separator");
            String url = "http://localhost:4200/auth/verification/" + suser.getToken();
            String body = "Welcom to our platform \n  use this link to verify your account is :" + Newligne + url;
            try {
                mailSending.send(user.getEmail(), "Welcome", body);
                return new ResponseEntity<Userco2>(user, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Userco2> registerEntreprise(Userco2 user1){
        if(userRepository.existsByUsername(user1.getUsername())) {
            return new ResponseEntity<Userco2>(HttpStatus.NOT_FOUND);
        }
        if(userRepository.existsByEmail(user1.getEmail())) {
            return new ResponseEntity<Userco2>(HttpStatus.BAD_REQUEST);
        }
        Userco2 user = new Userco2(user1.getName(),user1.getUsername(),user1.getEmail(),passwordEncoder.encode(user1.getPassword()),false,user1.getAddress(),false);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.ROLE_Entreprise)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);
        user.setRoles(roles);
        user.setValid(false);
        Userco2 suser= userRepository.save(user);
        if(suser != null ){
            String Newligne = System.getProperty("line.separator");
            String url = "http://localhost:4200/auth/verification/" + suser.getToken();
            String body = "Welcom to our platform \n   :" + Newligne + url;
            try {
                mailSending.send(user.getEmail(), "Welcome", body);
                return new ResponseEntity<Userco2>(user, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            } }

        else
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }


    }
    public ResponseEntity<Userco2> registerAdmin(@Valid @RequestBody Userco2 user)  {
        if(userRepository.existsByUsername(user.getUsername())) {
            return new ResponseEntity<Userco2>(HttpStatus.NOT_FOUND);
        }
        if(userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity<Userco2>(HttpStatus.NOT_FOUND);
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        Userco2 user1 = new Userco2(user.getName(),user.getUsername(),user.getEmail(),passwordEncoder.encode(user.getPassword()),false,user.getAddress(),false);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);
        user1.setRoles(roles);
        userRepository.save(user1);
        return new ResponseEntity<Userco2>(user1, HttpStatus.OK);
    }

    public Optional<Userco2> getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }
        return userRepository.findByUsername(username);
    }

}



