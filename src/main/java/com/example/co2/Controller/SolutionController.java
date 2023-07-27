package com.example.co2.Controller;

import com.example.co2.Entite.Solution;
import com.example.co2.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RequestMapping("/api/Solution")
@RestController
public class SolutionController {
    @Autowired
    SolutionService solutionService;

    @GetMapping("/list-Solution")
    public List<Solution> ListSolution() {
        return solutionService.getAllSolution();
    }

    @DeleteMapping("/delete-solution/{idSolution}")
    public void deleteSolution(@PathVariable("idSolution") Long idSolution) {
        solutionService.deleteSolution(idSolution);
    }

    @PostMapping("/add-solution")
    public Solution addSolution(@RequestBody @Valid Solution s1) {
        return solutionService.addsolution(s1);
    }

}
