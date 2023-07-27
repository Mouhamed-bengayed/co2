package com.example.co2.Dao;

import com.example.co2.Entite.Solution;
import com.example.co2.Entite.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository<Transport,Long> {
}
