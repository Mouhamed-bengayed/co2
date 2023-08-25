package com.example.co2.Service;

import com.example.co2.Dao.ActivityRepository;
import com.example.co2.Entite.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
@Autowired
ActivityRepository activityRepository;

    public Activity addActivity(Activity a1){
        Activity savedActivity = activityRepository.save(a1);
        return savedActivity;
    }
    public Activity deleteActivity(Long id){
        Optional<Activity> activity = activityRepository.findById(id);
        if(activity.isPresent()){
            return activity.get();
        }else
        {
            return null;
        }
    }
    public List<Activity> gettAllActivity(){
        activityRepository.findAll();
   return gettAllActivity();
    }
}
