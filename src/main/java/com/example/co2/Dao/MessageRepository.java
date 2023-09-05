package com.example.co2.Dao;

import com.example.co2.Entite.Food;
import com.example.co2.Entite.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findAllByUserco2Id(long id);
}
