package com.example.moy_sklad.controllers;

import com.example.moy_sklad.models.entity.Product;
import com.example.moy_sklad.models.entity.Storage;
import com.example.moy_sklad.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/storages")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Storage> getStorages() {
        return  storageService.getAllStorages();
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addStorage(@Valid @RequestBody Storage storage, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return  ResponseEntity.badRequest().body("Введены некорректные данные");
        }
        storageService.addStorage(storage);
        return  ResponseEntity.ok().body(storage);
    }

    @GetMapping (value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deleteStorage(@PathVariable Integer id) {
        storageService.deleteById(id);
        return  ResponseEntity.ok().body(id);
    }

    @PostMapping (value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity changeStorage(@Valid @RequestBody Storage storage, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return  ResponseEntity.badRequest().body("Введены некорректные данные");
        }
        storageService.addStorage(storage);
        return  ResponseEntity.ok().body(storage);
    }

}
