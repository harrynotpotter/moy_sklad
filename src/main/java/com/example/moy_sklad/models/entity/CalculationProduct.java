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
public class CalculationProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    @NotNull
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="storage_id")
    @NotNull
    private Storage storage;
    @Min(value = 1)
    private int quantity;

    public CalculationProduct(Product product,int quantity, Storage storage ) {
        this.product = product;
        this.quantity = quantity;
        this.storage = storage;
    }

    public CalculationProduct(int id, Product product, int quantity, Storage storage) {
        this.id = id;
        this.product = product;
        this.storage = storage;
        this.quantity = quantity;
    }
}
