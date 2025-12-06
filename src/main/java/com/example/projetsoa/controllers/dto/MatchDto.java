package com.example.projetsoa.controllers.dto;

import lombok.Data;

@Data
public class MatchDto {
    private String date;
    private String opponent;
    private Long stadiumId;  // use Long instead of long
}
