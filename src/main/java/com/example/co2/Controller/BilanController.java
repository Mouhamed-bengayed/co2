package com.example.co2.Controller;

import com.example.co2.Entite.Bilan;
import com.example.co2.Service.BilanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RequestMapping("/api/Categorie")
@RestController
public class BilanController {
    @Autowired
    BilanService bilanService ;

    @GetMapping("/list-Bilan")
    public List<Bilan> ListdBilan() {
        return bilanService.getAllBilan();
    }

    @DeleteMapping("/delete-Bilan/{idBilan}")
    public void deleteBilan(@PathVariable("idBilan") Long idBilan) {
        bilanService.deleteBilan(idBilan);
    }

    @PostMapping("/add-Bilan")
    public Bilan addBilan(@RequestBody @Valid Bilan s1) {
        return bilanService.addBilan(s1);
    }

}
