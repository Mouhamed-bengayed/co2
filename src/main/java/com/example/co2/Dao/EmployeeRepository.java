package com.example.co2.Dao;


import com.example.co2.Entite.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employer,Long> {
}
