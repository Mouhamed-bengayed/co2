package com.example.co2.Service;

import com.example.co2.Dao.BilanRepository;
import com.example.co2.Dao.UserRepository;
import com.example.co2.Dao.WorkRepository;
import com.example.co2.Dto.Works;
import com.example.co2.Entite.Bilan;
import com.example.co2.Entite.Userco2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class WorkService {

@Autowired
    WorkRepository workRepository;
@Autowired
    BilanRepository bilanRepository;
@Autowired
    UserRepository userRepository;
@Autowired
   UserService userService;

    public Double sum_works(Works works) {
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            Double sum =works.getA() *0.3+works.getB()*27.3+works.getC()*16.6;
            Bilan b1 = new Bilan();
            b1.setUserco2(userco2.get());
            b1.setSum_works_carbo(sum);
            bilanRepository.save(b1);
            return sum;
        }
        return null;


    }

}
