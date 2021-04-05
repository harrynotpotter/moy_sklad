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

    @ManyToOne
    @JoinColumn(name="receipt_id")
    private Receipt receipt;
}
