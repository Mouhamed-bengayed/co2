package com.example.co2.Entite;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean v1;
    private Boolean v2;
    private Boolean tP;
    private double voiteur;
    private double vole;
    private double transport_Public;
    private double sum_transport;
     @ManyToOne
    private Activity activity;
}
