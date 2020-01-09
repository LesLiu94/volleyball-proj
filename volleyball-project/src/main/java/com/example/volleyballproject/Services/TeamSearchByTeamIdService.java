package com.example.volleyballproject.Services;

import com.example.volleyballproject.DAOs.*;
import com.example.volleyballproject.DTOs.ManagementDTO;
import com.example.volleyballproject.DTOs.PlayerSearchDTO;
import com.example.volleyballproject.DTOs.TeamDTO;
import com.example.volleyballproject.DomainObjects.*;
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
    private ManagementDAO managementDAO;
    @Autowired
    private TeamDAO teamDAO;
    @Autowired
    private CardDAO cardDAO;

    private final static Logger logger = LogManager.getLogger(TeamSearchByTeamIdService.class);

    public TeamDTO findTeamPlayersByTeamId(Integer teamId){
        //grab all tuples from Management table with the corresponding teamId
        List<Management> managementList = managementDAO.findByTeamId(teamId);
        //grab all tuples from Player table with the corresponding teamId
        List<Player> playerList = playerDAO.findByTeamId(teamId);
        //grab the team name from the tuple from Team table with the corresponding teamId
        String teamName = teamDAO.findById(teamId).getTeamName();

        List<PlayerSearchDTO> playerResult = new ArrayList<>();
        List<ManagementDTO> managementResult = new ArrayList<>();

        //for every Management object, make sure active is true and populate relevant fields
        for(Management m: managementList){
            if(m.isActive()){
                ManagementDTO managementDTO = new ManagementDTO();
                Person person = personDAO.findById(m.getPerson().getId());
                managementDTO.setManagementID(m.getId());
                managementDTO.setFirstName(person.getFirstName());
                managementDTO.setLastName(person.getLastName());
                managementDTO.setTitle(m.getTitle());
                managementDTO.setAge(person.getAge());
                managementDTO.setTeamName(teamName);
                managementDTO.setActive(true);
                managementResult.add(managementDTO);
            }
        }

        //for every Player object, make sure active is true and populate relevant fields
        for (Player p: playerList) {
            if(p.isActive()){
                PlayerSearchDTO playerSearchDTO = new PlayerSearchDTO();
                int personId = p.getPerson().getId();
                Person person = personDAO.findById(personId);
                List<Card> cards = cardDAO.findByPerson(personId);
                playerSearchDTO.setPlayerId(p.getId());
                playerSearchDTO.setFirstName(person.getFirstName());
                playerSearchDTO.setLastName(person.getLastName());
                playerSearchDTO.setTeamName(teamName);
                playerSearchDTO.setJerseyNumber(p.getJerseyNumber());
                playerSearchDTO.setPlayerPosition(p.getPlayerPosition());
                playerSearchDTO.setCards(cards);
                playerSearchDTO.setActive(true);
                playerResult.add(playerSearchDTO);
            }

        }

        TeamDTO result = new TeamDTO();
        result.setTeamId(teamId);
        result.setPlayers(playerResult);
        result.setManagement(managementResult);
        return result;
    }
}
