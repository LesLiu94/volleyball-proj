package com.example.volleyballproject.DomainObjects;

import com.example.volleyballproject.Enums.PlayerPosition;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "volleyballschema", name = "player")
@SequenceGenerator(name = "player_id_seq",
        sequenceName = "player_id_seq",
        schema = "volleyballschema")

public @Data class Player {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_id_seq")
    private Integer id;

    @Column(name = "jersey_number")
    private int jerseyNumber;

    @Column(name = "player_position")
    @Enumerated(EnumType.STRING)
    private PlayerPosition playerPosition;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;

    @Column(name = "active")
    @NotNull
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId", referencedColumnName = "id",
            insertable = false, updatable = false)
    @NotNull
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId", referencedColumnName = "id",
            insertable = false, updatable = false)
    @NotNull
    private Team team;
}
