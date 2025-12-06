package com.example.projetsoa.controllers;

import com.example.projetsoa.Entity.Stadium;
import com.example.projetsoa.services.StadiumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @PostMapping
    public Stadium create(@RequestBody Stadium stadium) {
        return stadiumService.create(stadium);
    }

    @PutMapping("/{id}")
    public Stadium update(@PathVariable Long id, @RequestBody Stadium stadium) {
        return stadiumService.update(id, stadium);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        stadiumService.delete(id);
    }

    @GetMapping("/{id}")
    public Stadium getOne(@PathVariable Long id) {
        return stadiumService.getById(id);
    }

    @GetMapping
    public List<Stadium> getAll() {
        return stadiumService.getAll();
    }
}
