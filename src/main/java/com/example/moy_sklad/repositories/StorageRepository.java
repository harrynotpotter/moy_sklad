package com.example.moy_sklad.repositories;

import com.example.moy_sklad.models.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StorageRepository extends JpaRepository<Storage, Integer>, JpaSpecificationExecutor<Storage> {
}
