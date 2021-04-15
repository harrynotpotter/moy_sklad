package com.example.moy_sklad.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class Moving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    @Min(value = 1)
    private int quantity;

    @ManyToOne
    @JoinColumn(name="storage_from_id")
    @JsonProperty(value ="storage_from_id" )
    @NotNull
    private Storage storageFrom;

    @ManyToOne
    @JoinColumn(name="storage_to_id")
    @JsonProperty(value ="storage_to_id" )
    @NotNull
    private Storage storageTo;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonProperty(value ="product_id" )
    @NotNull
    private Product product;
}
