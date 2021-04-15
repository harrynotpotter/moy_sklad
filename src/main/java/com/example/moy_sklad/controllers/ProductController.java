package com.example.moy_sklad.controllers;

import com.example.moy_sklad.models.entity.Product;
import com.example.moy_sklad.models.entity.ProductOnStorage;
import com.example.moy_sklad.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/on_storages", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductOnStorage> getProductsOnReceipts() {
        return productService.getAllProductsOnStorages();
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addProduct(@Valid @RequestBody Product product, BindingResult bindingResult) {
        final Product result = productService.addProduct(product);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Введены некорректные данные");
        }

        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.ok().body(id);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeProduct(@Valid @RequestBody Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Введены некорректные данные");
        }
        productService.addProduct(product);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/{id}")
    public Product showProductById(@PathVariable(value = "id") Integer id) {
        return productService.get(id).orElse(new Product());
    }
}
