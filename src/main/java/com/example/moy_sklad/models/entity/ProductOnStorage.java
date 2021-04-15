package com.example.moy_sklad.models.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@Entity
public class ProductOnStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    @NotNull
    private Product product;
    @Min(value = 1)
    private int quantity;

    public ProductOnStorage(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductOnStorage(int id, Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.id = id;
    }
}
