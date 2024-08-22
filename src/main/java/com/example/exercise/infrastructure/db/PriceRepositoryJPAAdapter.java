package com.example.exercise.infrastructure.db;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.exercise.domain.aggregates.Price;
import com.example.exercise.domain.repositories.PriceRepository;
import com.example.exercise.infrastructure.mappers.PriceMapper;

@Repository
public class PriceRepositoryJPAAdapter implements PriceRepository{
    
    @Autowired
    private PriceRepositoryJPA priceRepositoryJPA;

    @Override
    public List<Price> findByDateAndProductIdAndBrandId(LocalDateTime date, String productId, String brandId){
        return this.priceRepositoryJPA.findPricesByDateAndProductIdAndBrandId(date, productId, brandId)
                .stream().map(PriceMapper::toModel).collect(Collectors.toList());
    }

}
