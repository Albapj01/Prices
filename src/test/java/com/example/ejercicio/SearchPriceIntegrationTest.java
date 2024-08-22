package com.example.ejercicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.exercise.ExerciseApplication;
import com.example.exercise.application.search_price.SearchPriceResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ExerciseApplication.class)
public class SearchPriceIntegrationTest {
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void when_date_is_20200614T1000_productId_is_35455_brandId_is_1_then_price_is_35_50_EUR() {
        
        ResponseEntity<SearchPriceResponse> res = restTemplate.getForEntity("/price/search?date=2020-06-14T10:00:00&idProduct=35455&idBrand=1", 
        SearchPriceResponse.class);

        assertTrue(res.getStatusCode().is2xxSuccessful());

        SearchPriceResponse response = res.getBody();

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-14-00.00.00", response.getDateStart());
        assertEquals("2020-12-31-23.59.59", response.getDateEnd());
        assertEquals("1", response.getRate());
        assertEquals("35,50 EUR", response.getPrice());

    }

    @Test
    public void when_date_is_20200614T1600_productId_is_35455_brandId_is_1_then_price_is_25_45_EUR() {
        
        ResponseEntity<SearchPriceResponse> res = restTemplate.getForEntity("/price/search?date=2020-06-14T16:00:00&idProduct=35455&idBrand=1", 
        SearchPriceResponse.class);

        assertTrue(res.getStatusCode().is2xxSuccessful());

        SearchPriceResponse response = res.getBody();

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-14-15.00.00", response.getDateStart());
        assertEquals("2020-06-14-18.30.00", response.getDateEnd());
        assertEquals("2", response.getRate());
        assertEquals("25,45 EUR", response.getPrice());

    }

    @Test
    public void when_date_is_20200614T2100_productId_is_35455_brandId_is_1_then_price_is_35_50_EUR() {
        
        ResponseEntity<SearchPriceResponse> res = restTemplate.getForEntity("/price/search?date=2020-06-14T21:00:00&idProduct=35455&idBrand=1", 
        SearchPriceResponse.class);

        assertTrue(res.getStatusCode().is2xxSuccessful());

        SearchPriceResponse response = res.getBody();

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-14-00.00.00", response.getDateStart());
        assertEquals("2020-12-31-23.59.59", response.getDateEnd());
        assertEquals("1", response.getRate());
        assertEquals("35,50 EUR", response.getPrice());

    }

    @Test
    public void when_date_is_20200615T1000_productId_is_35455_brandId_is_1_then_price_is_30_50_EUR() {
        
        ResponseEntity<SearchPriceResponse> res = restTemplate.getForEntity("/price/search?date=2020-06-15T10:00:00&idProduct=35455&idBrand=1", 
        SearchPriceResponse.class);

        assertTrue(res.getStatusCode().is2xxSuccessful());

        SearchPriceResponse response = res.getBody();

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-15-00.00.00", response.getDateStart());
        assertEquals("2020-06-15-11.00.00", response.getDateEnd());
        assertEquals("3", response.getRate());
        assertEquals("30,50 EUR", response.getPrice());

    }

    @Test
    public void when_date_is_20200616T2100_productId_is_35455_brandId_is_1_then_price_is_38_95_EUR() {
        
        ResponseEntity<SearchPriceResponse> res = restTemplate.getForEntity("/price/search?date=2020-06-16T21:00:00&idProduct=35455&idBrand=1", 
        SearchPriceResponse.class);

        assertTrue(res.getStatusCode().is2xxSuccessful());

        SearchPriceResponse response = res.getBody();

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-15-16.00.00", response.getDateStart());
        assertEquals("2020-12-31-23.59.59", response.getDateEnd());
        assertEquals("4", response.getRate());
        assertEquals("38,95 EUR", response.getPrice());

    }

    @Test
    public void when_date_is_20200614T1000_productId_is_11111_brandId_is_1_then_response_is_404() {
        
        ResponseEntity<String> res = restTemplate.getForEntity("/price/search?date=2021-06-14T10:00:00&idProduct=11111&idBrand=1", 
        String.class);

        assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
        assertTrue(res.getBody().contains("Price not found"));
    }

    @Test
    public void when_date_is_not_informed_then_response_is_400() {

        ResponseEntity<String> res = restTemplate.getForEntity("/price/search?idProduct=35455&idBrand=1", 
            String.class);
        
        assertEquals(HttpStatus.BAD_REQUEST, res.getStatusCode());
        assertTrue(res.getBody().contains("Missing required parameter: date"));

    }

    @Test
    public void when_date_has_invalid_format_and_productId_is_11111_brandId_is_1_then_response_is_400() {

        ResponseEntity<String> res = restTemplate.getForEntity("/price/search?date=hello&idProduct=35455&idBrand=1", 
            String.class);

        assertEquals(HttpStatus.BAD_REQUEST, res.getStatusCode());
        assertTrue(res.getBody().contains("Invalid date format"));

    }

}
