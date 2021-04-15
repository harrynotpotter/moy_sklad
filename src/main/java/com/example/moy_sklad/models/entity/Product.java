package com.example.moy_sklad.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String article;
    @NotEmpty
    private String name;
    @NotNull
    @JsonProperty("last_purchase_price")
    private BigDecimal lastPurchasePrice;
    @NotNull
    @JsonProperty("last_sale_price")
    private BigDecimal lastSalePrice;


//    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
//    private List<ProductOnStorage> productOnStorages;
}
