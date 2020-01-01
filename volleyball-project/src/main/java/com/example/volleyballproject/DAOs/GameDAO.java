package com.example.volleyballproject.DAOs;

import com.example.volleyballproject.DomainObjects.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GameDAO extends JpaRepository<Game, Long> {
    Game findById(Integer id);
    Game findByGameDate(Date gameDate);
}
