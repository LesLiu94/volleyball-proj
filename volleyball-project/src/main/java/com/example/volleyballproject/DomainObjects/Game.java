package com.example.volleyballproject.DomainObjects;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer id;

    @Column(name = "game_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date gameDate;

    @Column(name = "winner", insertable=false, updatable=false)
    @NotNull
    private Integer winnerID;

    @Column(name = "loser", insertable=false, updatable=false)
    @NotNull
    private Integer loserID;

    @Column(name = "win_points")
    private int winPoints;

    @Column(name = "lose_points")
    private int losePoints;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner", referencedColumnName = "id",
            insertable = false, updatable = false)
    private Person winner;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loser", referencedColumnName = "id",
            insertable = false, updatable = false)
    private Person loser;


}
