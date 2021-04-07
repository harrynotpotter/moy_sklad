package com.example.moy_sklad.services;

import com.example.moy_sklad.models.entity.Sale;
import com.example.moy_sklad.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    public void addSale(Sale sale){
        saleRepository.save(sale);
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public void deleteById(Integer id) {
        saleRepository.deleteById(id);
    }

}
