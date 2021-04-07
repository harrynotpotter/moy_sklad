package com.example.moy_sklad.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Entity
public class Sale {
    @Id
    private int number;
    private int quantity;
    private BigDecimal sale_price;
    @ManyToOne
    @JoinColumn(name="storage_id")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
