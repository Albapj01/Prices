package com.example.exercise.domain.services;

import java.time.LocalDateTime;
import java.util.Comparator;

import com.example.exercise.domain.aggregates.Price;
import com.example.exercise.domain.exceptions.PriceNotFoundException;
import com.example.exercise.domain.repositories.PriceRepository;

public class PriceService {

    private PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price searchPrice(LocalDateTime date, String productId, String brandId) throws PriceNotFoundException{
        return this.priceRepository.findByDateAndProductIdAndBrandId(date, productId, brandId).stream()
                .max(Comparator.comparingInt(Price::getPriority))
                .orElseThrow(() -> new PriceNotFoundException("Price with date " + date + ", productId " + productId + " and brandId "+ brandId + " not found."));
    }

}
