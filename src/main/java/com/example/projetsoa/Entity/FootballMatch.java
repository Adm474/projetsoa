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
    private String opponent;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Stadium stadium;
}
