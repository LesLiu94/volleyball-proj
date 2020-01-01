package com.example.volleyballproject.DAOs;

import com.example.volleyballproject.DomainObjects.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamDAO extends JpaRepository<Team, Long> {
    Team findByTeamId(Integer id);
    List<Team> findByTeamName(String teamName);
}
