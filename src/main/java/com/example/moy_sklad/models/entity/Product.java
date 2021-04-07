package com.example.moy_sklad.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String article;
    private String name;
    private BigDecimal last_purchase_price;
    private BigDecimal last_sale_price;

    public Product( String article, String name, BigDecimal last_purchase_price, BigDecimal last_sale_price) {
        this.article = article;
        this.name = name;
        this.last_purchase_price = last_purchase_price;
        this.last_sale_price = last_sale_price;
    }
}
