package com.example.co2.Dao;

import com.example.co2.Entite.Business;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Business,Long> {
}
