package com.example.co2.Dao;

import com.example.co2.Entite.Food;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
}
