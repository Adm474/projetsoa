package com.example.projetsoa.controllers.dto;

import lombok.Data;

@Data
public class MatchDto {
    private String date;
    private Long stadiumId;
    private Long homeClubId;
    private Long awayClubId;
}