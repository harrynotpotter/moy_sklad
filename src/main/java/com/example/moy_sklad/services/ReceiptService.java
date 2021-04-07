package com.example.moy_sklad.services;

import com.example.moy_sklad.models.entity.Receipt;
import com.example.moy_sklad.repositories.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {
    @Autowired
    ReceiptRepository receiptRepository;

    public void addReceipt(Receipt receipt){
        receiptRepository.save(receipt);

    }

    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    public void deleteById(Integer id) {
        receiptRepository.deleteById(id);
    }
}
