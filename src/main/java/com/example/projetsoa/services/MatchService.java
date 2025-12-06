package com.example.projetsoa.services;

import com.example.projetsoa.Entity.FootballMatch;
import com.example.projetsoa.Entity.Stadium;
import com.example.projetsoa.controllers.dto.MatchDto;
import com.example.projetsoa.repositoris.MatchRepository;
import com.example.projetsoa.repositoris.StadiumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final StadiumRepository stadiumRepository;

    public MatchService(MatchRepository matchRepository, StadiumRepository stadiumRepository) {
        this.matchRepository = matchRepository;
        this.stadiumRepository = stadiumRepository;
    }

    public FootballMatch create(MatchDto matchDto) {
        // Validate stadium exists
        Stadium stadium = stadiumRepository.findById(matchDto.getStadiumId())
                .orElseThrow(() -> new RuntimeException("Stadium not found with id: " + matchDto.getStadiumId()));

        FootballMatch match = new FootballMatch();
        match.setDate(matchDto.getDate());
        match.setOpponent(matchDto.getOpponent());
        match.setStadium(stadium);

        return matchRepository.save(match);
    }

    public Match update(Long id, Match match) {
        Match existingMatch = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found with id: " + id));

        existingMatch.setDate(match.getDate());
        existingMatch.setOpponent(match.getOpponent());

        // Validate stadium if it's being updated
        if (match.getStadium() != null && match.getStadium().getId() != null) {
            Stadium stadium = stadiumRepository.findById(match.getStadium().getId())
                    .orElseThrow(() -> new RuntimeException("Stadium not found with id: " + match.getStadium().getId()));
            existingMatch.setStadium(stadium);
        }

        return matchRepository.save(existingMatch);
    }

    public void delete(Long id) {
        if (!matchRepository.existsById(id)) {
            throw new RuntimeException("Match not found with id: " + id);
        }
        matchRepository.deleteById(id);
    }

    public Match getById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found with id: " + id));
    }

    public List<Match> getAll() {
        return matchRepository.findAll();
    }
}