package com.example.co2.Controller;

import com.example.co2.Dto.Works;
import com.example.co2.Service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/works")
public class WorkController {

    @Autowired
    WorkService workService;


    @PostMapping("/sum_carbo_works")
    public double calculer(@RequestBody Works works){
        return workService.sum_works(works);

    }



}
