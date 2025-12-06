package com.example.projetsoa.controllers;

import com.example.projetsoa.Entity.Club;
import com.example.projetsoa.services.ClubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping
    public Club create(@RequestBody Club club) {
        return clubService.create(club);
    }

    @PutMapping("/{id}")
    public Club update(@PathVariable Long id, @RequestBody Club club) {
        return clubService.update(id, club);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clubService.delete(id);
    }

    @GetMapping("/{id}")
    public Club getOne(@PathVariable Long id) {
        return clubService.getById(id);
    }

    @GetMapping
    public List<Club> getAll() {
        return clubService.getAll();
    }
}