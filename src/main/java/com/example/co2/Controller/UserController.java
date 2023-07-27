package com.example.co2.Controller;



import com.example.co2.Entite.Userr;
import com.example.co2.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

@Autowired
UserService userService;

    @GetMapping("/list-user")
    public List<Userr> ListUser() {
        return userService.getAllUser();
    }
    @PutMapping("/validate-user/{idUser}")
    public void validInscription(@PathVariable("idUser") Long idUser) {
        userService.validInscription(idUser);
    }
    @DeleteMapping("/delete-user/{idUser}")
    public void deleteAccount(@PathVariable("idUser") Long idUser) {
        userService.deleteUser(idUser);
    }

}
