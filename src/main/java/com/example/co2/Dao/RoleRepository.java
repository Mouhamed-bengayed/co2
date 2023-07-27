package com.example.co2.Dao;

import com.example.co2.Entite.Resources;
import com.example.co2.Entite.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
