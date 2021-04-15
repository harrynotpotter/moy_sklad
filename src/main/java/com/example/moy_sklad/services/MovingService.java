package com.example.moy_sklad.services;

import com.example.moy_sklad.models.entity.*;
import com.example.moy_sklad.repositories.CalculationProductRepository;
import com.example.moy_sklad.repositories.MovingRepository;
import com.example.moy_sklad.repositories.ProductRepository;
import com.example.moy_sklad.repositories.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovingService {
    @Autowired
    MovingRepository movingRepository;
    @Autowired
    ReceiptService receiptService;
    @Autowired
    SaleService saleService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    CalculationProductRepository calculationProductRepository;

    @Transactional
    public Moving addMoving(Moving moving){
        Product pr = productRepository.findById(moving.getProduct().getId())
                .orElseThrow(() -> new IllegalArgumentException("Prod id incorrect"));

        Storage storageFrom = storageRepository.findById(moving.getStorageFrom().getId())
                .orElseThrow(() -> new IllegalArgumentException("Storage from id incorrect"));

        Storage storageTo = storageRepository.findById(moving.getStorageTo().getId())
                .orElseThrow(() -> new IllegalArgumentException("Storage from id incorrect"));


        moving.setProduct(pr);
        moving.setStorageFrom(storageFrom);
        moving.setStorageTo(storageTo);
        Moving result = null;

        CalculationProduct calculationProductFrom = calculationProductRepository.findByProduct_IdAndStorage_Id(moving.getProduct().getId(), moving.getStorageFrom().getId());
        CalculationProduct calculationProductTo = calculationProductRepository.findByProduct_IdAndStorage_Id(moving.getProduct().getId(), moving.getStorageTo().getId());


        if (calculationProductRepository.getOne(calculationProductFrom.getId()).getQuantity() >=
        moving.getQuantity() ){
            result = movingRepository.save(moving);
            calculationProductRepository.save(new CalculationProduct(calculationProductFrom.getId(), moving.getProduct(), calculationProductRepository.getOne(calculationProductFrom.getId()).getQuantity() - moving.getQuantity(), moving.getStorageFrom()));
            if (calculationProductTo == null) {
                calculationProductRepository.save(new CalculationProduct(moving.getProduct(), moving.getQuantity(), moving.getStorageTo()));
            } else {

                calculationProductRepository.save(new CalculationProduct(calculationProductTo.getId(), moving.getProduct(), calculationProductRepository.getOne(calculationProductTo.getId()).getQuantity() + moving.getQuantity(),
                        moving.getStorageTo()));
            }


        }

        return result;
    }

    public List<Moving> getAllMovings() {
        return movingRepository.findAll();
    }

    public void deleteById(Integer id) {
        movingRepository.deleteById(id);
    }
}
