package com.example.co2.Service;

import com.example.co2.Dao.FeedRepository;
import com.example.co2.Entite.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedService {
@Autowired
    FeedRepository feedRepository;


    public Feed addFeed(Feed f1){
        Feed savedFeed= feedRepository.save(f1);
        return savedFeed;
    }
    public List<Feed> getAllFeed(){
        return feedRepository.findAll();

    }

    public Feed deleteLevel(Long id){
        Optional<Feed> feed = feedRepository.findById(id);
        if(feed.isPresent()){
            return feed.get();
        }else
        {
            return null;
        }
    }

}


