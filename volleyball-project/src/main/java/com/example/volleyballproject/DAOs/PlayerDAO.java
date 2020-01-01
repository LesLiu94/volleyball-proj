package com.example.volleyballproject.DAOs;

import com.example.volleyballproject.DomainObjects.Player;
import com.example.volleyballproject.Enums.PlayerPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDAO extends JpaRepository<Player,Long> {
    Player findById(Integer id);
    List<Player> findByTeamId(Integer teamId);
    List<Player> findByPlayerPosition(PlayerPosition playerPosition);
    List<Player> findByJerseyNumber(int jerseyNumber);
}
