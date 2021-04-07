package com.example.moy_sklad.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Receipt {
    @Id
    private int number;
    private int quantity;
    private BigDecimal purchase_price;
    @ManyToOne
    @JoinColumn(name="storage_id")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
