package com.example.co2.Controller;

import com.example.co2.Entite.Activity;
import com.example.co2.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RequestMapping("/api/Activity")
@RestController
public class ActivityController {
@Autowired
ActivityService activityService ;

    @GetMapping("/list-activity")
    public List<Activity> ListActivity() {
        return activityService.gettAllActivity();
    }

    @DeleteMapping("/delete-activity/{idActivity}")
    public void deleteActivity(@PathVariable("idActivity") Long idActivity) {
        activityService.deleteActivity(idActivity);
    }

    @PostMapping("/add-activity")
    public Activity addActivity(@RequestBody @Valid Activity s1) {
        return activityService.addActivity(s1);
    }
}
