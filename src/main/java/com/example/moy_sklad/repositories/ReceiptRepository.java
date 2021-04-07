package com.example.moy_sklad.repositories;

import com.example.moy_sklad.models.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReceiptRepository extends JpaRepository<Receipt,Integer>, JpaSpecificationExecutor<Receipt> {
}
