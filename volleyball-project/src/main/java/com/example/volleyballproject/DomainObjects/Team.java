package com.example.volleyballproject.DomainObjects;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "volleyballschema", name = "team")
@SequenceGenerator(name = "team_id_seq",
        sequenceName = "team_id_seq",
        schema = "volleyballschema")

public @Data class Team {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_id_seq")
    private Integer id;

    @Column(name = "team_name")
    @NotNull
    private String teamName;

    @Column(name = "place")
    private String place;
}
