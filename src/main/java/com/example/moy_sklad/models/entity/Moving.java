package com.example.moy_sklad.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class Moving {
    @Id
    private int number;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="storage_from_id")
    private Storage storageFrom;

    @ManyToOne
    @JoinColumn(name="storage_to_id")
    private Storage storageTo;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
