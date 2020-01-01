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
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    private Player player;

    @OneToOne(fetch = FetchType.LAZY)
    private Management managements;
}
