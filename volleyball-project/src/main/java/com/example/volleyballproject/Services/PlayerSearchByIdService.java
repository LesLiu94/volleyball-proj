package com.example.volleyballproject.Services;

import com.example.volleyballproject.DAOs.CardDAO;
import com.example.volleyballproject.DAOs.PersonDAO;
import com.example.volleyballproject.DAOs.PlayerDAO;
import com.example.volleyballproject.DAOs.TeamDAO;
import com.example.volleyballproject.DTOs.PlayerSearchDTO;
import com.example.volleyballproject.DomainObjects.Card;
import com.example.volleyballproject.DomainObjects.Person;
import com.example.volleyballproject.DomainObjects.Player;
import com.example.volleyballproject.DomainObjects.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerSearchByIdService {

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    private TeamDAO teamDAO;
    @Autowired
    private CardDAO cardDAO;

    private final static Logger logger = LogManager.getLogger(PlayerSearchByIdService.class);

    public PlayerSearchDTO findPlayerById(Integer playerId){

        logger.info("Finding player by player id.");
        Player player = playerDAO.findById(playerId);
        int personId = player.getPerson().getId();
        Person person = personDAO.findById(personId);
        Team team = teamDAO.findById(player.getTeam().getId());
        List<Card> cards = cardDAO.findByPerson(personId);

        PlayerSearchDTO playerSearchDTO = new PlayerSearchDTO();
        playerSearchDTO.setPlayerId(playerId);
        playerSearchDTO.setFirstName(person.getFirstName());
        playerSearchDTO.setLastName(person.getLastName());
        playerSearchDTO.setJerseyNumber(player.getJerseyNumber());
        playerSearchDTO.setPlayerPosition(player.getPlayerPosition());
        playerSearchDTO.setHeight(player.getHeight());
        playerSearchDTO.setWeight(player.getWeight());
        playerSearchDTO.setAge(person.getAge());
        playerSearchDTO.setTeamName(team.getTeamName());
        playerSearchDTO.setActive(player.isActive());
        playerSearchDTO.setCards(cards);

        return playerSearchDTO;
    }
}
