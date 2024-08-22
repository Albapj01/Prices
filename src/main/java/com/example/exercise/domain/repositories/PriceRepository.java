package com.example.exercise.domain.repositories;

import java.time.LocalDateTime;
import java.util.List;

import com.example.exercise.domain.aggregates.Price;

public interface PriceRepository {
    
    public List<Price> findByDateAndProductIdAndBrandId(LocalDateTime date, String productId, String brandId);

}
