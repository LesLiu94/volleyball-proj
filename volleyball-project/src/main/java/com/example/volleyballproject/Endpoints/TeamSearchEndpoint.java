package com.example.volleyballproject.Endpoints;

import com.example.volleyballproject.DTOs.TeamDTO;
import com.example.volleyballproject.DomainObjects.Team;
import com.example.volleyballproject.Services.TeamSearchByNameService;
import com.example.volleyballproject.Services.TeamSearchByTeamIdService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/TeamSearch")
public class TeamSearchEndpoint {

    @Autowired
    private TeamSearchByNameService teamSearchByNameService;

    @Autowired
    private TeamSearchByTeamIdService teamSearchByTeamIdService;

    final static Logger logger = LogManager.getLogger(TeamSearchEndpoint.class);

    @ApiOperation(value = "find all teams with given names")
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/byName", produces = "application/json")
    @ResponseBody
    public List<Team> findTeamByName(String name){

        logger.info("Handling request for team search by name");
        List<Team> teamList = teamSearchByNameService.findTeamByTeamName(name);

        logger.info("Successfully generated a response for team search by name");
        return teamList;
    }

    @ApiOperation(value = "find team with given id")
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/byId", produces = "application/json")
    @ResponseBody
    public TeamDTO findingTeamById(Integer id){

        logger.info("Handling request for team search by id");
        TeamDTO team = teamSearchByTeamIdService.findTeamPlayersByTeamId(id);

        logger.info("Successfully generated a response for team search by id");
        return team;
    }

}
