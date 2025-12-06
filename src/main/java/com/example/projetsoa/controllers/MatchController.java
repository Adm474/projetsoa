package com.example.projetsoa.controllers;

import com.example.projetsoa.Entity.FootballMatch;
import com.example.projetsoa.controllers.dto.MatchDto;
import com.example.projetsoa.services.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public FootballMatch create(@RequestBody MatchDto matchDto) {
        return matchService.create(matchDto);
    }

    @PutMapping("/{id}")
    public FootballMatch update(@PathVariable Long id, @RequestBody MatchDto matchDto) {
        return matchService.update(id, matchDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        matchService.delete(id);
    }

    @GetMapping("/{id}")
    public FootballMatch getOne(@PathVariable Long id) {
        return matchService.getById(id);
    }

    @GetMapping
    public List<FootballMatch> getAll() {
        return matchService.getAll();
    }
}