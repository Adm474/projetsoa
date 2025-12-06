package com.example.projetsoa.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FootballMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Stadium stadium;

    @ManyToOne
    @JoinColumn(name = "home_club_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Club homeClub;

    @ManyToOne
    @JoinColumn(name = "away_club_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Club awayClub;
}