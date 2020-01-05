package com.example.volleyballproject.Services;

import com.example.volleyballproject.DAOs.PersonDAO;
import com.example.volleyballproject.DAOs.PlayerDAO;
import com.example.volleyballproject.DAOs.TeamDAO;
import com.example.volleyballproject.DomainObjects.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamSearchByNameService {

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    private TeamDAO teamDAO;

    private final static Logger logger = LogManager.getLogger(TeamSearchByNameService.class);

    public List<Team> findTeamByTeamName(String teamName){
        logger.info("Finding team by team name.");
        List<Team> result = teamDAO.findByTeamName(teamName);

        return result;

    }
}
