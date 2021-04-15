package com.example.moy_sklad.controllers;

import com.example.moy_sklad.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {ProductController.class})
@DirtiesContext
class ProductControllerTest {
    @Autowired
    MockMvc mvc;


    @Test
    void getProductsOnReceipts() throws Exception {
        mvc.perform(get("/products/on_storages")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void getProducts() throws Exception {
        mvc.perform(get("/products/")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void addProduct() throws Exception {
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


        String badJson = "{\n" +
                "  \"id\": \"1\",\n" +
                "  \"article\":\"\",\n" +
                "  \"last_purchase_price\":\"\",\n" +
                "  \"last_sale_price\":\"1111.1\",\n" +
                "  \"name\":\"test1\"\n" +
                "}";

        mvc.perform(post("/products/add")
                .contentType("application/json")
                .content(badJson))
                .andExpect(status().isBadRequest());


    }

    @Test
    void deleteProduct() throws Exception {
        mvc.perform(get("/products/delete/1")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void changeProduct() throws Exception {

        String json = "{\n" +
                "  \"id\": \"2\",\n" +
                "  \"article\":\"test1\",\n" +
                "  \"last_purchase_price\":\"1111.1\",\n" +
                "  \"last_sale_price\":\"1111.1\",\n" +
                "  \"name\":\"test1\"\n" +
                "}";

        mvc.perform(post("/products/update")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());


        String badJson = "{\n" +
                "  \"id\": \"2\",\n" +
                "  \"article\":\"\",\n" +
                "  \"last_purchase_price\":\"\",\n" +
                "  \"last_sale_price\":\"1111.1\",\n" +
                "  \"name\":\"test1\"\n" +
                "}";

        mvc.perform(post("/products/update")
                .contentType("application/json")
                .content(badJson))
                .andExpect(status().isBadRequest());

    }
}