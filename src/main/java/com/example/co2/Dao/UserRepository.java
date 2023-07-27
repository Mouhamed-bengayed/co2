package com.example.co2.Dao;


import com.example.co2.Entite.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Userr,Long> {
    Userr findByEmail(String username);
    Optional<Userr> findByUsername(String username);
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
