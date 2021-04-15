package com.example.moy_sklad.integration;


import com.example.moy_sklad.models.entity.Product;
import com.example.moy_sklad.models.entity.Storage;
import com.example.moy_sklad.repositories.ProductRepository;
import com.example.moy_sklad.repositories.StorageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationIntegrationTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StorageRepository storageRepository;

    @Test
    void ProductToEndTest() throws Exception {
        String json = "{\n" +
                "  \"id\": \"1\",\n" +
                "  \"article\":\"test1\",\n" +
                "  \"last_purchase_price\":\"1111.1\",\n" +
                "  \"last_sale_price\":\"1111.1\",\n" +
                "  \"name\":\"test1\"\n" +
                "}";

        mvc.perform(post("/products/add")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());

        Optional<Product> resultProduct= productRepository.findById(1);

        assertTrue(resultProduct.isPresent());
        resultProduct.ifPresent(p -> {
            assertEquals(p.getArticle(), "test1");
            assertEquals(p.getLastPurchasePrice(),new BigDecimal("1111.10"));
            assertEquals(p.getLastPurchasePrice(), new BigDecimal("1111.10"));
            assertEquals(p.getName(),"test1");
        });
    }

    @Test
    void StorageToEndTest() throws Exception {
        String json = "{\n" +
                "  \"name\":\"СКЛАД1\"\n" +
                "}";

        mvc.perform(post("/storages/add")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());

        Optional<Storage> resultStorage= storageRepository.findById(1);

        assertTrue(resultStorage.isPresent());
        resultStorage.ifPresent(p -> {
            assertEquals(p.getName(),"СКЛАД1");
        });
    }




}
