package com.example.moy_sklad.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Receipt {
    @Id
    private int number;

    @ManyToOne
    @JoinColumn(name="storage_id")
    private Storage storage;

    @OneToMany(mappedBy = "receipt", fetch = FetchType.LAZY)
    private List<Product> productList;
}
