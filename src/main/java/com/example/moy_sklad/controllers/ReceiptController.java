package com.example.moy_sklad.controllers;

import com.example.moy_sklad.models.entity.Receipt;
import com.example.moy_sklad.models.entity.Sale;
import com.example.moy_sklad.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Receipt> getReceipts() {
        return  receiptService.getAllReceipts();
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addReceipt(@RequestBody Receipt receipt) {
        receiptService.addReceipt(receipt);
        return  ResponseEntity.ok().body(receipt);
    }

    @GetMapping (value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deleteReceipt(@PathVariable Integer id) {
        receiptService.deleteById(id);
        return  ResponseEntity.ok().body(id);
    }

    @PostMapping (value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity changeReceipt(@RequestBody Receipt receipt) {
        receiptService.addReceipt(receipt);
        return  ResponseEntity.ok().body(receipt);
    }
}
