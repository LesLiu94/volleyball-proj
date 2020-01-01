package com.example.volleyballproject.DomainObjects;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(schema = "volleyballschema", name = "game")
@SequenceGenerator(name = "game_id_seq",
        sequenceName = "game_id_seq",
        schema = "volleyballschema")

public @Data class Game {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
    private int id;

    @Column(name = "game_date")
    private Date game_date;

    @Column(name = "winner", insertable=false, updatable=false)
    @NotNull
    private int winnerID;

    @Column(name = "loser", insertable=false, updatable=false)
    @NotNull
    private int loserID;

    @Column(name = "win_points")
    private int win_points;

    @Column(name = "lose_points")
    private int lose_points;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner", referencedColumnName = "id",
            insertable = false, updatable = false)
    private Person winner;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loser", referencedColumnName = "id",
            insertable = false, updatable = false)
    private Person loser;


}
