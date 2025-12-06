package com.example.projetsoa.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private String opponent;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;
}
