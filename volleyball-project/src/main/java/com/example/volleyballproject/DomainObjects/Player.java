package com.example.volleyballproject.DomainObjects;

import com.example.volleyballproject.CompositeKeys.PlayerAndManagementCompositeKey;
import com.example.volleyballproject.Enums.PlayerPosition;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "volleyballschema", name = "player")

public @Data class Player {

    @EmbeddedId
    private PlayerAndManagementCompositeKey playerAndManagementCompositeKey;

    @Column(name = "person_id", insertable=false, updatable=false)
    @NotNull
    private int person_id;

    @Column(name = "jersey_number")
    private int jersey_number;

    @Column(name = "player_position")
    @Enumerated(EnumType.STRING)
    private PlayerPosition player_position;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;

    @Column(name = "team_id", insertable=false, updatable=false)
    @NotNull
    private int team_id;

    @Column(name = "active")
    @NotNull
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id",
            insertable = false, updatable = false)
    @NotNull
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id",
            insertable = false, updatable = false)
    @NotNull
    private Team team;
}
