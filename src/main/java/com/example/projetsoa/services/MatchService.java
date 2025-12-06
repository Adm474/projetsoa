package com.example.projetsoa.services;


import com.example.projetsoa.Entity.Match;
import com.example.projetsoa.controllers.dto.MatchDto;
import com.example.projetsoa.repositoris.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match create(MatchDto match) {
        Match match1 = new Match();
        match1.setDate(match.getDate());
        match1.setOpponent(match.getOpponent());
        match1.getStadium().setId(match.getStadiumId());
        return matchRepository.save(match1);
    }

    public Match update(Long id, Match match) {
        Match m = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));

        m.setDate(match.getDate());
        m.setOpponent(match.getOpponent());
        m.setStadium(match.getStadium());
        return matchRepository.save(m);
    }

    public void delete(Long id) {
        matchRepository.deleteById(id);
    }

    public Match getById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));
    }

    public List<Match> getAll() {
        return matchRepository.findAll();
    }
}

