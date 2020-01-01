package com.example.volleyballproject.DomainObjects;

import com.example.volleyballproject.Enums.CardColor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "volleyballschema", name = "card")
@SequenceGenerator(name = "card_id_seq",
        sequenceName = "card_id_seq",
        schema = "volleyballschema")

public @Data class Card {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_id_seq")
    private Integer id;

    @Column(name = "color")
    private CardColor color;

    @Column(name = "person")
    @NotNull
    private Integer personID;

    @Column(name = "game")
    @NotNull
    private Integer gameID;

    @Column(name = "reason")
    private String reason;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person", referencedColumnName = "id",
            insertable = false, updatable = false)
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game", referencedColumnName = "id",
        insertable = false, updatable = false)
    private Game game;
}
