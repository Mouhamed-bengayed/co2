package com.example.co2.Service;

import com.example.co2.Dao.BilanRepository;
import com.example.co2.Dao.UserRepository;
import com.example.co2.Entite.Bilan;
import com.example.co2.Entite.Userco2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BilanService {

    @Autowired
    BilanRepository bilanRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;



    public  Bilan GetBilanByuser(){
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            return bilanRepository.findByUserco2(userco2.get());
        }
        return null;
    }
}