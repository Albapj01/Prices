package com.example.exercise.domain.repositories;

import java.util.List;

import com.example.exercise.domain.aggregates.Price;

public interface PriceRepository {
    
    public List<Price> findAll();

}
