package com.example.moy_sklad.repositories;

import com.example.moy_sklad.models.entity.ProductOnStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductOnStorageRepository extends JpaRepository<ProductOnStorage,Integer>, JpaSpecificationExecutor<ProductOnStorage> {
    //ProductOnStorage findProductOnStorageByProduct_Id(int id);
    ProductOnStorage findByProduct_Id(int productId);
}
