package com.example.moy_sklad.controllers;

import com.example.moy_sklad.models.entity.Moving;
import com.example.moy_sklad.models.entity.Product;
import com.example.moy_sklad.services.MovingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movings")
public class MovingController {
    @Autowired
    private MovingService movingService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Moving> getMovings() {
        return movingService.getAllMovings();
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addMoving(@RequestBody Moving moving) {
        movingService.addMoving(moving);
        return ResponseEntity.ok().body(moving);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMoving(@PathVariable Integer id) {
        movingService.deleteById(id);
        return ResponseEntity.ok().body(id);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeMoving(@RequestBody Moving moving) {
        movingService.addMoving(moving);
        return ResponseEntity.ok().body(moving);
    }
}
