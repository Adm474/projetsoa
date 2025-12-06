package com.example.projetsoa.services;

import com.example.projetsoa.Entity.Club;
import com.example.projetsoa.Entity.FootballMatch;
import com.example.projetsoa.Entity.Stadium;
import com.example.projetsoa.controllers.dto.MatchDto;
import com.example.projetsoa.repositoris.ClubRepository;
import com.example.projetsoa.repositoris.MatchRepository;
import com.example.projetsoa.repositoris.StadiumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final StadiumRepository stadiumRepository;
    private final ClubRepository clubRepository;

    public MatchService(MatchRepository matchRepository, StadiumRepository stadiumRepository, ClubRepository clubRepository) {
        this.matchRepository = matchRepository;
        this.stadiumRepository = stadiumRepository;
        this.clubRepository = clubRepository;
    }

    public FootballMatch create(MatchDto matchDto) {
        // Validate stadium exists
        Stadium stadium = stadiumRepository.findById(matchDto.getStadiumId())
                .orElseThrow(() -> new RuntimeException("Stadium not found with id: " + matchDto.getStadiumId()));

        // Validate home club exists
        Club homeClub = clubRepository.findById(matchDto.getHomeClubId())
                .orElseThrow(() -> new RuntimeException("Home club not found with id: " + matchDto.getHomeClubId()));

        // Validate away club exists
        Club awayClub = clubRepository.findById(matchDto.getAwayClubId())
                .orElseThrow(() -> new RuntimeException("Away club not found with id: " + matchDto.getAwayClubId()));

        FootballMatch match = new FootballMatch();
        match.setDate(matchDto.getDate());
        match.setStadium(stadium);
        match.setHomeClub(homeClub);
        match.setAwayClub(awayClub);

        return matchRepository.save(match);
    }

    public FootballMatch update(Long id, MatchDto matchDto) {
        FootballMatch existingMatch = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found with id: " + id));

        existingMatch.setDate(matchDto.getDate());

        // Validate and update stadium
        if (matchDto.getStadiumId() != null) {
            Stadium stadium = stadiumRepository.findById(matchDto.getStadiumId())
                    .orElseThrow(() -> new RuntimeException("Stadium not found with id: " + matchDto.getStadiumId()));
            existingMatch.setStadium(stadium);
        }

        // Validate and update home club
        if (matchDto.getHomeClubId() != null) {
            Club homeClub = clubRepository.findById(matchDto.getHomeClubId())
                    .orElseThrow(() -> new RuntimeException("Home club not found with id: " + matchDto.getHomeClubId()));
            existingMatch.setHomeClub(homeClub);
        }

        // Validate and update away club
        if (matchDto.getAwayClubId() != null) {
            Club awayClub = clubRepository.findById(matchDto.getAwayClubId())
                    .orElseThrow(() -> new RuntimeException("Away club not found with id: " + matchDto.getAwayClubId()));
            existingMatch.setAwayClub(awayClub);
        }

        return matchRepository.save(existingMatch);
    }

    public void delete(Long id) {
        if (!matchRepository.existsById(id)) {
            throw new RuntimeException("Match not found with id: " + id);
        }
        matchRepository.deleteById(id);
    }

    public FootballMatch getById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found with id: " + id));
    }

    public List<FootballMatch> getAll() {
        return matchRepository.findAll();
    }
}