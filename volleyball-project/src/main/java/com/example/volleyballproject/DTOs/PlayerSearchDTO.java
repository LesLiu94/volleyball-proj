package com.example.volleyballproject.DTOs;

import com.example.volleyballproject.DomainObjects.Card;
import com.example.volleyballproject.Enums.PlayerPosition;
import lombok.Data;

import java.util.List;

public @Data class PlayerSearchDTO {

    private Integer playerId;
    private String firstName;
    private String lastName;
    private int jerseyNumber;
    private PlayerPosition playerPosition;
    private double height;
    private double weight;
    private int age;
    private String teamName;
    private boolean active;
    private List<Card> cards;

}
