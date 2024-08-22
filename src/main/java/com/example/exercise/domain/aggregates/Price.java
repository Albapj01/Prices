package com.example.exercise.domain.aggregates;

import java.time.LocalDateTime;

import com.example.exercise.domain.vos.Amount;
import com.example.exercise.domain.vos.Currency;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {
    
    private final String brandId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Integer priceList;
    private final String productId;
    private final Integer priority;
    private final Amount amount;
    private final Currency currency;

}
