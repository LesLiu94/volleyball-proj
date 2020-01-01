package com.example.volleyballproject.DomainObjects;

import com.example.volleyballproject.Enums.Title;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "volleyballschema", name = "management")
@SequenceGenerator(name = "management_id_seq",
        sequenceName = "management_id_seq",
        schema = "volleyballschema")

public @Data class Management {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "management_id_seq")
    private int id;

    @Column(name = "person_id", insertable=false, updatable=false)
    @NotNull
    private int personId;

    @Column(name = "title")
    @NotNull
    private Title title;

    @Column(name = "team_id", insertable=false, updatable=false)
    @NotNull
    private int teamId;

    @Column(name = "active")
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId", referencedColumnName = "id",
            insertable=false, updatable=false)
    @NotNull
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId", referencedColumnName = "id",
            insertable=false, updatable=false)
    @NotNull
    private Team team;

}
