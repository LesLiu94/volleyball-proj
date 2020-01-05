package com.example.volleyballproject.DTOs;

import com.example.volleyballproject.Enums.Title;
import lombok.Data;

public @Data class ManagementDTO {

    private Integer managementID;
    private String firstName;
    private String lastName;
    private Title title;
    private int age;
    private String teamName;
    private boolean active;

}
