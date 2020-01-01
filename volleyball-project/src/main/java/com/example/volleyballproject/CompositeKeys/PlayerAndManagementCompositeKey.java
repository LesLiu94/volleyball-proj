package com.example.volleyballproject.CompositeKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public @Data class PlayerAndManagementCompositeKey implements Serializable {

    @Column(name = "person_id")
    private int person_id;

    @Column(name = "team_id")
    private int team_id;

    public PlayerAndManagementCompositeKey(){}

    public PlayerAndManagementCompositeKey(int person_id, int team_id){
        this.person_id = person_id;
        this.team_id = team_id;
    }
}
