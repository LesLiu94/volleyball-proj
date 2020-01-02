package com.example.volleyballproject.Services;

import com.example.volleyballproject.DAOs.PersonDAO;
import com.example.volleyballproject.DAOs.PlayerDAO;
import com.example.volleyballproject.DAOs.TeamDAO;
import com.example.volleyballproject.DTOs.PlayerSearchResult;
import com.example.volleyballproject.DomainObjects.Person;
import com.example.volleyballproject.DomainObjects.Player;
import com.example.volleyballproject.DomainObjects.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeamSearchByTeamIdService {

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    private TeamDAO teamDAO;

    private final static Logger logger = LogManager.getLogger(TeamSearchByTeamIdService.class);

    public List<PlayerSearchResult> findTeamPlayersByTeamId(Integer teamId){
        List<Player> teamPlayers = playerDAO.findByTeamId(teamId);
        List<PlayerSearchResult> result = new ArrayList<>();

        for (Player p: teamPlayers) {
            if(p.isActive()){
                PlayerSearchResult playerSearchResult = new PlayerSearchResult();
                Person person = personDAO.findById(p.getPersonId());
                Team team = teamDAO.findByTeamId(p.getTeamId());
                playerSearchResult.setPlayerId(p.getId());
                playerSearchResult.setFirstName(person.getFirstName());
                playerSearchResult.setLastName(person.getLastName());
                playerSearchResult.setTeamName(team.getTeamName());
                playerSearchResult.setJerseyNumber(p.getJerseyNumber());
                playerSearchResult.setPlayerPosition(p.getPlayerPosition());
                playerSearchResult.setActive(p.isActive());
                result.add(playerSearchResult);
            }

        }

        return result;
    }
}
