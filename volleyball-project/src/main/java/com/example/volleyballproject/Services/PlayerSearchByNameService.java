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
    public List<PlayerSearchResult> findPlayerByName(String name){
        logger.info("Finding player by a player name.");
        List<Person> foundBySingleName = personDAO.findByFirstName(name);
        foundBySingleName.addAll(personDAO.findByLastName(name));

        if(foundBySingleName.isEmpty()){
            return null;
        }

        List<PlayerSearchResult> result = new ArrayList<>();

        if(foundBySingleName.size() == 1){
            Person p = foundBySingleName.get(0);
            Player player = playerDAO.findById(p.getId());
            Team team = teamDAO.findByTeamId(player.getTeamId());
            List<Card> cards = cardDAO.findByPerson(p.getId());
            PlayerSearchResult playerSearchResult = new PlayerSearchResult();
            playerSearchResult.setPlayerId(player.getId());
            playerSearchResult.setFirstName(p.getFirstName());
            playerSearchResult.setLastName(p.getLastName());
            playerSearchResult.setJerseyNumber(player.getJerseyNumber());
            playerSearchResult.setPlayerPosition(player.getPlayerPosition());
            playerSearchResult.setHeight(player.getHeight());
            playerSearchResult.setWeight(player.getWeight());
            playerSearchResult.setTeamName(team.getTeamName());
            playerSearchResult.setActive(player.isActive());
            playerSearchResult.setCards(cards);

            result.add(playerSearchResult);
            return result;
        }

        else {
            //if multiple people match criteria, don't show height, weight, and cards
            for (Person p: foundBySingleName) {
                Player player = playerDAO.findById(p.getId());
                Team team = teamDAO.findByTeamId(player.getTeamId());
                PlayerSearchResult playerSearchResult = new PlayerSearchResult();
                playerSearchResult.setPlayerId(player.getId());
                playerSearchResult.setFirstName(p.getFirstName());
                playerSearchResult.setLastName(p.getLastName());
                playerSearchResult.setJerseyNumber(player.getJerseyNumber());
                playerSearchResult.setPlayerPosition(player.getPlayerPosition());
                playerSearchResult.setTeamName(team.getTeamName());
                playerSearchResult.setActive(player.isActive());

                result.add(playerSearchResult);

            }
            return result;
        }

    }
    //case for inputting first and last name
    public List<PlayerSearchResult> findPlayerByNames(String firstName, String lastName){
        logger.info("Finding player by player first name and player last name.");
        List<Person> people = personDAO.findByFirstNameAndLastName(firstName, lastName);

        if(people.isEmpty()){
            return null;
        }

        List<PlayerSearchResult> result = new ArrayList<>();

        if(people.size() == 1){
            Person p = people.get(0);
            Player player = playerDAO.findById(p.getId());
            Team team = teamDAO.findByTeamId(player.getTeamId());
            List<Card> cards = cardDAO.findByPerson(p.getId());
            PlayerSearchResult playerSearchResult = new PlayerSearchResult();
            playerSearchResult.setPlayerId(player.getId());
            playerSearchResult.setFirstName(p.getFirstName());
            playerSearchResult.setLastName(p.getLastName());
            playerSearchResult.setJerseyNumber(player.getJerseyNumber());
            playerSearchResult.setPlayerPosition(player.getPlayerPosition());
            playerSearchResult.setHeight(player.getHeight());
            playerSearchResult.setWeight(player.getWeight());
            playerSearchResult.setTeamName(team.getTeamName());
            playerSearchResult.setActive(player.isActive());
            playerSearchResult.setCards(cards);

            result.add(playerSearchResult);
            return result;
        }

        else{
            //if multiple people match criteria, don't show height, weight, and cards
            for (Person p: people) {
                Player player = playerDAO.findById(p.getId());
                Team team = teamDAO.findByTeamId(player.getTeamId());
                PlayerSearchResult playerSearchResult = new PlayerSearchResult();
                playerSearchResult.setPlayerId(player.getId());
                playerSearchResult.setFirstName(p.getFirstName());
                playerSearchResult.setLastName(p.getLastName());
                playerSearchResult.setJerseyNumber(player.getJerseyNumber());
                playerSearchResult.setPlayerPosition(player.getPlayerPosition());
                playerSearchResult.setTeamName(team.getTeamName());
                playerSearchResult.setActive(player.isActive());

                result.add(playerSearchResult);

            }
            return result;
        }

    }

}
