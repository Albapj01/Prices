package com.example.exercise.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercise.application.search_price.SearchPriceRequest;
import com.example.exercise.application.search_price.SearchPriceResponse;
import com.example.exercise.application.search_price.SearchPriceUseCase;
import com.example.exercise.domain.exceptions.InvalidDateException;
import com.example.exercise.domain.exceptions.PriceNotFoundException;
import com.example.exercise.domain.util.FormatUtil;
import com.example.exercise.domain.util.ValidateDate;

@RestController
public class PriceController {
    
    @Autowired
    private SearchPriceUseCase useCase;

    @GetMapping("/price/search")
    public ResponseEntity<SearchPriceResponse> searchPrice(
        @RequestParam(required = true) String date,
        @RequestParam(required = true) String idProduct,
        @RequestParam(required = true) String idBrand

    ) throws PriceNotFoundException {

        if(!ValidateDate.isValidDateFormat(date)){
            throw new InvalidDateException("Invalid date format");
        }

        SearchPriceRequest request = SearchPriceRequest.builder()
                    .date(FormatUtil.dateParse(date))
                    .productId(idProduct)
                    .brandId(idBrand)
                    .build();

        SearchPriceResponse response = useCase.execute(request);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
