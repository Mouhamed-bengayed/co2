package com.example.co2.Controller;


import com.example.co2.Entite.Feed;
import com.example.co2.Service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RequestMapping("/api/Level")
@RestController
public class FeedController {

    @Autowired
    FeedService feedService;

    @GetMapping("/list-feed")
    public List<Feed> ListFeed() {
        return feedService.getAllFeed();
    }

    @DeleteMapping("/delete-Feed/{idFeed}")
    public void deleteFeed(@PathVariable("idFeed") Long idFeed) {
        feedService.deleteLevel(idFeed);
    }

    @PostMapping("/add-Feed")
    public Feed addFeed(@RequestBody @Valid Feed A1) {
        return feedService.addFeed(A1);
    }

}
