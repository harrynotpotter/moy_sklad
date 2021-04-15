package com.example.moy_sklad.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    @Min(value = 1)
    private int quantity;
    @NotNull
    private BigDecimal purchasePrice;
    @ManyToOne
    @JoinColumn(name="storage_id")
    @JsonProperty(value ="storage_id" )
    @NotNull
    private Storage storageId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="product_id")
    @JsonProperty(value ="product_id" )
    @NotNull
    private Product product;
}
