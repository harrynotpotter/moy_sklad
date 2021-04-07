package com.example.moy_sklad.repositories;

import com.example.moy_sklad.models.entity.Moving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MovingRepository extends JpaRepository<Moving, Integer>, JpaSpecificationExecutor<Moving> {
}
