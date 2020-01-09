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
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlayerSearchByNameService {

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    private TeamDAO teamDAO;
    @Autowired
    private CardDAO cardDAO;

    private final static Logger logger = LogManager.getLogger(PlayerSearchByNameService.class);

    //case for inputting a single name
    public List<PlayerSearchDTO> findPlayerByName(String name){
        logger.info("Finding player by a player name.");
        List<Person> foundBySingleName = personDAO.findByFirstName(name);
        foundBySingleName.addAll(personDAO.findByLastName(name));

        if(foundBySingleName.isEmpty()){
            return null;
        }

        List<PlayerSearchDTO> result = new ArrayList<>();

        for (Person p: foundBySingleName) {
            Player player = playerDAO.findById(p.getId());
            Team team = teamDAO.findById(player.getTeam().getId());
            List<Card> cards = cardDAO.findByPerson(p.getId());
            PlayerSearchDTO playerSearchDTO = new PlayerSearchDTO();
            playerSearchDTO.setPlayerId(player.getId());
            playerSearchDTO.setFirstName(p.getFirstName());
            playerSearchDTO.setLastName(p.getLastName());
            playerSearchDTO.setJerseyNumber(player.getJerseyNumber());
            playerSearchDTO.setPlayerPosition(player.getPlayerPosition());
            playerSearchDTO.setHeight(player.getHeight());
            playerSearchDTO.setWeight(player.getWeight());
            playerSearchDTO.setAge(p.getAge());
            playerSearchDTO.setTeamName(team.getTeamName());
            playerSearchDTO.setActive(player.isActive());
            playerSearchDTO.setCards(cards);

            result.add(playerSearchDTO);

        }
        return result;

    }
    //case for inputting first and last name
    public List<PlayerSearchDTO> findPlayerByNames(String firstName, String lastName){
        logger.info("Finding player by player first name and player last name.");
        List<Person> people = personDAO.findByFirstNameAndLastName(firstName, lastName);

        if(people.isEmpty()){
            return null;
        }

        List<PlayerSearchDTO> result = new ArrayList<>();

        for (Person p: people) {
            Player player = playerDAO.findById(p.getId());
            Team team = teamDAO.findById(player.getTeam().getId());
            List<Card> cards = cardDAO.findByPerson(p.getId());
            PlayerSearchDTO playerSearchDTO = new PlayerSearchDTO();
            playerSearchDTO.setPlayerId(player.getId());
            playerSearchDTO.setFirstName(p.getFirstName());
            playerSearchDTO.setLastName(p.getLastName());
            playerSearchDTO.setJerseyNumber(player.getJerseyNumber());
            playerSearchDTO.setPlayerPosition(player.getPlayerPosition());
            playerSearchDTO.setHeight(player.getHeight());
            playerSearchDTO.setWeight(player.getWeight());
            playerSearchDTO.setAge(p.getAge());
            playerSearchDTO.setTeamName(team.getTeamName());
            playerSearchDTO.setActive(player.isActive());
            playerSearchDTO.setCards(cards);

            result.add(playerSearchDTO);
        }
        return result;
    }

}
