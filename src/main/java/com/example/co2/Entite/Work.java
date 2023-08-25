package com.example.co2.Entite;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number_Email;
    private int number_H_Utilisation_pc;
    private int number_H_Utilisation_smartphone;
    private float sum_works_carbo;
    @ManyToOne
    private Activity activity;
}
