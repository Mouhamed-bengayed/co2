package com.example.co2.Entite;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Bilan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double sum_works_carbo;
    private Double sum_transport_carbo;
    private Double sum_alimontation_carbo;

    @OneToOne
    private Userco2 userco2;


}
