package com.example.exercise.application.search_price;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchPriceResponse {
    
    private final String productId;
    private final String brandId;
    private final String rate;
    private final String dateStart;
    private final String dateEnd; 
    private final String price; 

}
