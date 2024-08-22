package com.example.exercise.infrastructure.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercise.application.search_price.SearchPriceRequest;
import com.example.exercise.application.search_price.SearchPriceResponse;
import com.example.exercise.application.search_price.SearchPriceUseCase;
import com.example.exercise.domain.exceptions.PriceNotFoundException;

@RestController
public class PriceController {
    
    @Autowired
    private SearchPriceUseCase useCase;

    @GetMapping("/price/search")
    public ResponseEntity<SearchPriceResponse> searchPrice(
        @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final LocalDateTime date,
        @RequestParam(required = true) Integer idProduct,
        @RequestParam(required = true) Integer idBrand

    ) throws PriceNotFoundException {

        SearchPriceRequest request = SearchPriceRequest.builder()
                    .date(date)
                    .productId(idProduct)
                    .brandId(idBrand)
                    .build();

        SearchPriceResponse response = useCase.execute(request);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
