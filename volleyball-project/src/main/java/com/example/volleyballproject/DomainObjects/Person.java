package com.example.volleyballproject.DomainObjects;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(schema = "volleyballschema", name = "person")
@SequenceGenerator(name = "person_id_seq",
        sequenceName = "person_id_seq",
        schema = "volleyballschema")

public @Data class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "first_name")
    @NotNull
    private String first_name;

    @NotNull
    @Column(name = "last_name")
    private String last_name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Player> players;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Management> managements;
}
