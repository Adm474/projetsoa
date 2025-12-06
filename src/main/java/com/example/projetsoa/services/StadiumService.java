package com.example.projetsoa.services;


import com.example.projetsoa.Entity.Stadium;
import com.example.projetsoa.repositoris.StadiumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;

    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public Stadium create(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public Stadium update(Long id, Stadium stadium) {
        Stadium s = stadiumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stadium not found"));

        s.setName(stadium.getName());
        s.setCity(stadium.getCity());
        s.setCapacity(stadium.getCapacity());
        return stadiumRepository.save(s);
    }

    public void delete(Long id) {
        stadiumRepository.deleteById(id);
    }

    public Stadium getById(Long id) {
        return stadiumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stadium not found"));
    }

    public List<Stadium> getAll() {
        return stadiumRepository.findAll();
    }
}


