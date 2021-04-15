package com.example.moy_sklad.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private int quantity;
    @NotNull
    private BigDecimal sale_price;
    @ManyToOne
    @JoinColumn(name="storage_id")
    @JsonProperty(value ="storage_id" )
    @NotNull
    private Storage storage;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonProperty(value ="product_id" )
    @NotNull
    private Product product;
}
