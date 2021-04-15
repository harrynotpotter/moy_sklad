package com.example.moy_sklad.services;

import com.example.moy_sklad.models.entity.*;
import com.example.moy_sklad.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReceiptService {

    @Autowired
    CalculationProductRepository calculationProductRepository;
    @Autowired
    ReceiptRepository receiptRepository;
    @Autowired
    ProductOnStorageRepository productOnStorageRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StorageRepository storageRepository;

    @Transactional
    public Receipt addReceipt(Receipt receipt) {
        Product pr = productRepository.findById(receipt.getProduct().getId())
                .orElseThrow(() -> new IllegalArgumentException("Prod id incorrect"));

        Storage storage = storageRepository.findById(receipt.getStorageId().getId())
                .orElseThrow(() -> new IllegalArgumentException("Storage id incorrect"));
        receipt.setProduct(pr);
        receipt.setStorageId(storage);

        CalculationProduct calculationProduct = calculationProductRepository.findByProduct_IdAndStorage_Id(receipt.getProduct().getId(), receipt.getStorageId().getId());
        ProductOnStorage productOnStorage = productOnStorageRepository.findByProduct_Id(receipt.getProduct().getId());


        final Receipt result = receiptRepository.save(receipt);
        pr.setLastPurchasePrice(result.getPurchasePrice());
        productRepository.save(pr);

        if (productOnStorage == null) {
            productOnStorageRepository.save(new ProductOnStorage(receipt.getProduct(), receipt.getQuantity()));
        } else {
            productOnStorageRepository.save(new ProductOnStorage(productOnStorage.getId(), receipt.getProduct(), receipt.getQuantity() + productOnStorageRepository.getOne(productOnStorage.getId()).getQuantity()));
        }

        if (calculationProduct == null) {
            calculationProductRepository.save(new CalculationProduct(receipt.getProduct(), receipt.getQuantity(), receipt.getStorageId()));
        } else {
            calculationProductRepository.save(new CalculationProduct(calculationProduct.getId(), receipt.getProduct(), receipt.getQuantity() + calculationProductRepository.getOne(calculationProduct.getId()).getQuantity(), calculationProduct.getStorage()));
        }

        return result;
    }

    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    public void deleteById(Integer id) {
        receiptRepository.deleteById(id);
    }
}
