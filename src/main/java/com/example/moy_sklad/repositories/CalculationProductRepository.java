package com.example.moy_sklad.repositories;

import com.example.moy_sklad.models.entity.CalculationProduct;
import com.example.moy_sklad.models.entity.ProductOnStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CalculationProductRepository extends JpaRepository<CalculationProduct, Integer>, JpaSpecificationExecutor<CalculationProduct> {
    CalculationProduct findByProduct_IdAndStorage_Id(int productId, int storageId);
}
