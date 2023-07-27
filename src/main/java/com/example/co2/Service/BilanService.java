package com.example.co2.Service;

import com.example.co2.Dao.BilanRepository;
import com.example.co2.Entite.Bilan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BilanService {

@Autowired
BilanRepository bilanRepository;

    public Bilan addBilan(Bilan c1){
        Bilan savedBilan=bilanRepository.save(c1);
        return savedBilan;
    }
public List<Bilan> getAllBilan(){
    bilanRepository.findAll();
    return getAllBilan();
}
    public Bilan deleteBilan(Long id){
        Optional<Bilan> bilan = bilanRepository.findById(id);
        if(bilan.isPresent()){
            return bilan.get();
        }else
        {
            return null;
        }
    }

}
