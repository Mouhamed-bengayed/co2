package com.example.co2.Dao;

import com.example.co2.Entite.Resources;
import com.example.co2.Entite.Role;
import com.example.co2.Entite.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByUserName(String name);

}
