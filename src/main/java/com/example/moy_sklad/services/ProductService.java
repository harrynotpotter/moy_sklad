package com.example.moy_sklad.services;

import com.example.moy_sklad.models.entity.Product;
import com.example.moy_sklad.models.entity.ProductOnStorage;
import com.example.moy_sklad.repositories.ProductOnStorageRepository;
import com.example.moy_sklad.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductOnStorageRepository productOnStorageRepository;

    public void addProductOnStorage(ProductOnStorage productOnStorage) {
        productOnStorageRepository.save(productOnStorage);
    }

    public List<ProductOnStorage> getAllProductsOnStorages() {
        return productOnStorageRepository.findAll();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> get(Integer id) {
        return productRepository.findById(id);
    }
}
