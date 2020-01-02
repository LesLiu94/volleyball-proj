package com.example.volleyballproject.Services;

import com.example.volleyballproject.DAOs.CardDAO;
import com.example.volleyballproject.DAOs.PersonDAO;
import com.example.volleyballproject.DAOs.PlayerDAO;
import com.example.volleyballproject.DAOs.TeamDAO;
import com.example.volleyballproject.DTOs.PlayerSearchResult;
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

    public PlayerSearchResult findPlayerById(Integer playerId){

        logger.info("Finding player by player id.");
        Player player = playerDAO.findById(playerId);
        Person person = personDAO.findById(player.getPersonId());
        Team team = teamDAO.findByTeamId(player.getTeamId());
        List<Card> cards = cardDAO.findByPerson(player.getPersonId());

        PlayerSearchResult playerSearchResult = new PlayerSearchResult();
        playerSearchResult.setPlayerId(playerId);
        playerSearchResult.setFirstName(person.getFirstName());
        playerSearchResult.setLastName(person.getLastName());
        playerSearchResult.setJerseyNumber(player.getJerseyNumber());
        playerSearchResult.setPlayerPosition(player.getPlayerPosition());
        playerSearchResult.setHeight(player.getHeight());
        playerSearchResult.setWeight(player.getWeight());
        playerSearchResult.setTeamName(team.getTeamName());
        playerSearchResult.setActive(player.isActive());
        playerSearchResult.setCards(cards);

        return playerSearchResult;
    }
}
