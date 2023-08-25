package com.example.co2.Controller;


import com.example.co2.Dto.Alimontaion;
import com.example.co2.Dto.Works;
import com.example.co2.Entite.Food;
import com.example.co2.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RequestMapping("/api/Level")
@RestController
public class FoodController {

    @Autowired
    FoodService foodService;
    @PostMapping("/sum_carbo_works")
    public double calculer(@RequestBody Alimontaion alimontaion){
        return foodService.sum_alimontation(alimontaion);

    }
}
