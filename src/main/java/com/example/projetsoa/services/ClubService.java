package com.example.projetsoa.services;

import com.example.projetsoa.Entity.Club;
import com.example.projetsoa.repositoris.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public Club create(Club club) {
        return clubRepository.save(club);
    }

    public Club update(Long id, Club club) {
        Club existingClub = clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Club not found"));

        existingClub.setName(club.getName());
        existingClub.setLeagueName(club.getLeagueName());
        return clubRepository.save(existingClub);
    }

    public void delete(Long id) {
        clubRepository.deleteById(id);
    }

    public Club getById(Long id) {
        return clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Club not found"));
    }

    public List<Club> getAll() {
        return clubRepository.findAll();
    }
}