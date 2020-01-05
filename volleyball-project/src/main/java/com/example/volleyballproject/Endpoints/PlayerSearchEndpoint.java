package com.example.volleyballproject.Endpoints;

import com.example.volleyballproject.DTOs.PlayerSearchDTO;
import com.example.volleyballproject.Services.PlayerSearchByIdService;
import com.example.volleyballproject.Services.PlayerSearchByNameService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/PlayerSearch")
public class PlayerSearchEndpoint{
    @Autowired
    private PlayerSearchByNameService playerSearchByNameService;
    @Autowired
    private PlayerSearchByIdService playerSearchByIdService;

    final static Logger logger = LogManager.getLogger(PlayerSearchEndpoint.class);

    @ApiOperation(value = "find all players with first or last name of given name")
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/bySingleName", produces = "application/json")
    @ResponseBody
    public List<PlayerSearchDTO> findPlayers(String name){

        logger.info("Handling request for player search by a name");
        List<PlayerSearchDTO> playerList = playerSearchByNameService.findPlayerByName(name);

        logger.info("Successfully generated a response for finding a player by a name");
        return playerList;

    }

    @ApiOperation(value = "find all players with first and last name of given names")
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/byFullName", produces = "application/json")
    @ResponseBody
    public List<PlayerSearchDTO> findPlayers(String first, String last){

        logger.info("Handling request for player search by first and last name");
        List<PlayerSearchDTO> playerList = playerSearchByNameService.findPlayerByNames(first,last);

        logger.info("Successfully generated a response for finding a player by first and last name");
        return playerList;
    }

    @ApiOperation(value = "find player with given player id")
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/byPlayerId", produces = "application/json")
    @ResponseBody
    public PlayerSearchDTO findPlayer(Integer id){

        logger.info("Handling request for player search by id");
        PlayerSearchDTO player = playerSearchByIdService.findPlayerById(id);

        logger.info(("Successfully generated a response for finding a player by id"));
        return player;
    }

}
