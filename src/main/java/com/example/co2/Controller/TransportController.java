package com.example.co2.Controller;

import com.example.co2.Dto.Transport;
import com.example.co2.Dto.Works;
import com.example.co2.Service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TransportController {

    @Autowired
    TransportService transportService;

    @PostMapping("/sum_carbo_tP")
    public double calculer(@RequestBody Transport transport){
        return transportService.sum_transport_public(transport);
    }
    @PostMapping("/sum_carbo_tvt")
    public double calculer_vt(@RequestBody Transport transport){
        return transportService.sum_transport_voiture(transport);
    }
    @PostMapping("/sum_carbo_tl")
    public double calculer_vl(@RequestBody Transport transport){
        return transportService.sum_transport_vl(transport);
    }
}
