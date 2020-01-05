package com.example.volleyballproject.DTOs;

import com.example.volleyballproject.DomainObjects.Management;
import lombok.Data;

import java.util.List;

public @Data class TeamDTO {

    private Integer teamId;
    private List<ManagementDTO> management;
    private List<PlayerSearchDTO> players;
}
