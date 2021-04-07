package com.example.moy_sklad.controllers;

import com.example.moy_sklad.models.entity.Sale;
import com.example.moy_sklad.models.entity.Storage;
import com.example.moy_sklad.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Sale> getSales() {
        return  saleService.getAllSales();
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addSale(@RequestBody Sale sale) {
        saleService.addSale(sale);
        return  ResponseEntity.ok().body(sale);
    }

    @GetMapping (value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deleteSale(@PathVariable Integer id) {
        saleService.deleteById(id);
        return  ResponseEntity.ok().body(id);
    }

    @PostMapping (value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity changeSale(@RequestBody Sale sale) {
        saleService.addSale(sale);
        return  ResponseEntity.ok().body(sale);
    }

}
