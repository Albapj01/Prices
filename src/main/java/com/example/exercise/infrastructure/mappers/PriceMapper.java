package com.example.exercise.infrastructure.mappers;

import com.example.exercise.domain.aggregates.Price;
import com.example.exercise.domain.vos.Amount;
import com.example.exercise.domain.vos.Currency;
import com.example.exercise.infrastructure.db.PriceJPA;

public class PriceMapper {

    private PriceMapper() {} 
    
    public static Price toModel(PriceJPA priceJPA) {
        return Price.builder()
                    .amount(new Amount(priceJPA.getPrice()))
                    .brandId(priceJPA.getBrandId())
                    .currency(Currency.valueOf(priceJPA.getCurrency()))
                    .endDate(priceJPA.getEndDate())
                    .priceList(Integer.valueOf(priceJPA.getPriceList()))
                    .priority(priceJPA.getPriority())
                    .productId(priceJPA.getProductId())
                    .startDate(priceJPA.getStartDate())
                    .build();
    }

}
