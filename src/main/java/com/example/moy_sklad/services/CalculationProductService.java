package com.example.moy_sklad.services;

import com.example.moy_sklad.models.entity.CalculationProduct;
import com.example.moy_sklad.repositories.CalculationProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationProductService {
    @Autowired
    CalculationProductRepository calculationProductRepository;

    public List<CalculationProduct> getAllCalculations() {
        return calculationProductRepository.findAll();
    }

    public CalculationProduct addCalculation(CalculationProduct calculation) {
        return calculationProductRepository.save(calculation);
    }

    public void deleteById(Integer id) {
        calculationProductRepository.deleteById(id);
    }
}
