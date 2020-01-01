package com.example.volleyballproject.DomainObjects;

import com.example.volleyballproject.CompositeKeys.PlayerAndManagementCompositeKey;
import com.example.volleyballproject.Enums.Title;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "volleyballschema", name = "management")

public @Data class Management {

    @EmbeddedId
    private PlayerAndManagementCompositeKey playerAndManagementCompositeKey;

    @Column(name = "person_id", insertable=false, updatable=false)
    @NotNull
    private int person_id;

    @Column(name = "title")
    @NotNull
    private Title title;

    @Column(name = "team_id", insertable=false, updatable=false)
    @NotNull
    private int team_id;

    @Column(name = "active")
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id",
            insertable=false, updatable=false)
    @NotNull
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id",
            insertable=false, updatable=false)
    @NotNull
    private Team team;

}
