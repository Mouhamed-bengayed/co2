package com.example.co2.Entite;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     @ManyToOne
    private Activity activity;
}
