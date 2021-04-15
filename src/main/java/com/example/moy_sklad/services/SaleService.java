package com.example.moy_sklad.services;

import com.example.moy_sklad.models.entity.*;
import com.example.moy_sklad.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    ProductOnStorageRepository productOnStorageRepository;
    @Autowired
    CalculationProductRepository calculationProductRepository;

    @Transactional
    public Sale addSale(Sale sale) {
        Product pr = productRepository.findById(sale.getProduct().getId())
                .orElseThrow(() -> new IllegalArgumentException("Prod id incorrect"));

        Storage storage = storageRepository.findById(sale.getStorage().getId())
                .orElseThrow(() -> new IllegalArgumentException("Storage id incorrect"));
        sale.setProduct(pr);
        sale.setStorage(storage);
        Sale result = null;

        CalculationProduct calculationProduct = calculationProductRepository.findByProduct_IdAndStorage_Id(sale.getProduct().getId(), sale.getStorage().getId());
        ProductOnStorage productOnStorage = productOnStorageRepository.findByProduct_Id(sale.getProduct().getId());

        if (calculationProductRepository.getOne(calculationProduct.getId()).getQuantity() >= sale.getQuantity()
                && productOnStorageRepository.getOne(productOnStorage.getId()).getQuantity() >= sale.getQuantity()) {
            result = saleRepository.save(sale);

            pr.setLastSalePrice(result.getSale_price());
            productRepository.save(pr);

            if (productOnStorage == null) {
                productOnStorageRepository.save(new ProductOnStorage(sale.getProduct(), sale.getQuantity()));
            } else {
                productOnStorageRepository.save(new ProductOnStorage(productOnStorage.getId(), sale.getProduct(), productOnStorageRepository.getOne(productOnStorage.getId()).getQuantity() - sale.getQuantity()));
            }

            if (calculationProduct == null) {
                calculationProductRepository.save(new CalculationProduct(sale.getProduct(), sale.getQuantity(), sale.getStorage()));
            } else {
                calculationProductRepository.save(new CalculationProduct(calculationProduct.getId(), sale.getProduct(), calculationProductRepository.getOne(calculationProduct.getId()).getQuantity() - sale.getQuantity(), calculationProduct.getStorage()));
            }

        }

        return result;
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public void deleteById(Integer id) {
        saleRepository.deleteById(id);
    }

}
