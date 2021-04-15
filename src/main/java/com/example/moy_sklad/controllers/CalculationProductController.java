package com.example.moy_sklad.controllers;

import com.example.moy_sklad.models.entity.CalculationProduct;
import com.example.moy_sklad.models.entity.Moving;
import com.example.moy_sklad.services.CalculationProductService;
import com.example.moy_sklad.services.MovingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/calculation")
public class CalculationProductController {
    @Autowired
    private CalculationProductService calculationProductService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<CalculationProduct> getCalculations() {
        return calculationProductService.getAllCalculations();
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCalculation(@Valid @RequestBody CalculationProduct calculation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return  ResponseEntity.badRequest().body("Введены некорректные данные");
        }
        final CalculationProduct result = calculationProductService.addCalculation(calculation);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCalculation(@PathVariable Integer id) {
        calculationProductService.deleteById(id);
        return ResponseEntity.ok().body(id);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeCalculation(@Valid @RequestBody CalculationProduct calculationProduct, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return  ResponseEntity.badRequest().body("Введены некорректные данные");
        }
        final CalculationProduct result = calculationProductService.addCalculation(calculationProduct);
        return ResponseEntity.ok().body(result);
    }
}
