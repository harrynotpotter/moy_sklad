package com.example.moy_sklad.services;

import com.example.moy_sklad.models.entity.Moving;
import com.example.moy_sklad.repositories.MovingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovingService {
    @Autowired
    MovingRepository movingRepository;

    public void addMoving(Moving moving){
        movingRepository.save(moving);
    }

    public List<Moving> getAllMovings() {
        return movingRepository.findAll();
    }

    public void deleteById(Integer id) {
        movingRepository.deleteById(id);
    }
}
