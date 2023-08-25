package com.example.co2.Service;


import com.example.co2.Dao.BilanRepository;
import com.example.co2.Dao.UserRepository;
import com.example.co2.Dto.Transport;
import com.example.co2.Dto.Works;
import com.example.co2.Entite.Bilan;
import com.example.co2.Entite.Userco2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransportService {



    @Autowired
    BilanRepository bilanRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    public Double sum_transport_public(Transport transport) {
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            Double sum =transport.getA()*30;
            Bilan b1 = new Bilan();
            b1.setUserco2(userco2.get());
            b1.setSum_transport_carbo(sum);
            bilanRepository.save(b1);
            return sum;
        }
        return null;
    }
    public Double sum_transport_voiture(Transport transport) {
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            Double sum =transport.getA()*130;
            Bilan b1 = new Bilan();
            b1.setUserco2(userco2.get());
            b1.setSum_transport_carbo(sum);
            bilanRepository.save(b1);
            return sum;
        }
        return null;
    }
    public Double sum_transport_vl(Transport transport) {
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            Double sum =transport.getA()*0.4;
            Bilan b1 = new Bilan();
            b1.setUserco2(userco2.get());
            b1.setSum_transport_carbo(sum);
            bilanRepository.save(b1);
            return sum;
        }
        return null;
    }

}
