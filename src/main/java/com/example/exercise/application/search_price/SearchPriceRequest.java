package com.example.exercise.application.search_price;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchPriceRequest {
    
    private final LocalDateTime date;
    private final String productId;
    private final String brandId;

}
