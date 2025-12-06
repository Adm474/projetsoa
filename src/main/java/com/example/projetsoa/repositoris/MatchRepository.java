package com.example.projetsoa.repositoris;

import com.example.projetsoa.Entity.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<FootballMatch, Long> {
}
