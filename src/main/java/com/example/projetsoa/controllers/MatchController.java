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
    public FootballMatch create(@RequestBody MatchDto match) {
        return matchService.create(match);
    }

    @PutMapping("/{id}")
    public Match update(@PathVariable Long id, @RequestBody Match match) {
        return matchService.update(id, match);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        matchService.delete(id);
    }

    @GetMapping("/{id}")
    public Match getOne(@PathVariable Long id) {
        return matchService.getById(id);
    }

    @GetMapping
    public List<Match> getAll() {
        return matchService.getAll();
    }
}



