package com.example.exercise.infrastructure.db;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.exercise.application.mappers.PriceMapper;
import com.example.exercise.domain.aggregates.Price;
import com.example.exercise.domain.repositories.PriceRepository;

@Repository
public class PriceRepositoryJPAAdapter implements PriceRepository{
    
    @Autowired
    private PriceRepositoryJPA priceRepositoryJPA;

    @Override
    public List<Price> findAll() {
        return this.priceRepositoryJPA.findAll()
        .stream().map(PriceMapper::toModel).collect(Collectors.toList());
    }

}
