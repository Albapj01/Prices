package com.example.exercise.infrastructure.db;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PriceRepositoryJPA extends JpaRepository<PriceJPA, Long> {

    @Query("SELECT p FROM PriceJPA p WHERE (p.startDate <= :date AND p.endDate >= :date) AND p.productId = :productId AND p.brandId = :brandId")
    List<PriceJPA> findPricesByDateAndProductIdAndBrandId( @Param("date") LocalDateTime date, @Param("productId") String productId, @Param("brandId") String brandId);
    
} 
