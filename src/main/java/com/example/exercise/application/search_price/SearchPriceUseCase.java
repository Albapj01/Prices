package com.example.exercise.application.search_price;

import com.example.exercise.domain.aggregates.Price;
import com.example.exercise.domain.exceptions.PriceNotFoundException;
import com.example.exercise.domain.services.PriceService;
import com.example.exercise.domain.util.FormatUtil;

public class SearchPriceUseCase {
    
    private PriceService priceService;

    public SearchPriceUseCase(PriceService priceService) {
        this.priceService = priceService;
    }

    public SearchPriceResponse execute(SearchPriceRequest request) throws PriceNotFoundException{

        Price price = this.priceService.searchPrice(request.getDate(), request.getProductId(), request.getBrandId());

        return SearchPriceResponse.builder().productId(price.getProductId()).brandId(price.getBrandId())
                .dateStart(FormatUtil.toFormat(price.getStartDate())).dateEnd(FormatUtil.toFormat(price.getEndDate()))
                .price(price.getFinalPrice()).rate(price.getPriceList().toString()).build();

    }
    
}
