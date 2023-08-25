package com.example.co2.Dao;

import com.example.co2.Entite.Bilan;

import com.example.co2.Entite.Userco2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BilanRepository extends JpaRepository<Bilan,Long> {

    Bilan findByUserco2(Userco2 userco2);
}
