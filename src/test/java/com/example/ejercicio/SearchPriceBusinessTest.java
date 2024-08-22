package com.example.ejercicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.exercise.application.search_price.SearchPriceRequest;
import com.example.exercise.application.search_price.SearchPriceResponse;
import com.example.exercise.application.search_price.SearchPriceUseCase;
import com.example.exercise.domain.aggregates.Price;
import com.example.exercise.domain.exceptions.PriceNotFoundException;
import com.example.exercise.domain.repositories.PriceRepository;
import com.example.exercise.domain.services.PriceService;
import com.example.exercise.domain.util.FormatUtil;
import com.example.exercise.domain.vos.Amount;
import com.example.exercise.domain.vos.Currency;

public class SearchPriceBusinessTest {

    private final PriceRepository priceRepository = Mockito.mock(PriceRepository.class);
    private final PriceService priceService = new PriceService(priceRepository);
    private final SearchPriceUseCase searchPriceUseCase = new SearchPriceUseCase(priceService);
    
    @Test
    public void when_date_is_20200614T1000_productId_is_35455_brandId_is_1_then_price_is_35_50_EUR() throws PriceNotFoundException{

        Mockito.when(priceRepository.findByDateAndProductIdAndBrandId(FormatUtil.dateParse("2020-06-14-10.00.00"), 35455, 1))
                .thenReturn(this.getPrices().stream()
                .filter(price -> price.getStartDate().isBefore(FormatUtil.dateParse("2020-06-14-10.00.00"))
                && price.getEndDate().isAfter(FormatUtil.dateParse("2020-06-14-10.00.00")))
                .collect(Collectors.toList()));

        SearchPriceRequest request = SearchPriceRequest.builder().date(FormatUtil.dateParse("2020-06-14-10.00.00"))
                .productId(35455).brandId(1).build();

        SearchPriceResponse response = searchPriceUseCase.execute(request);

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-14-00.00.00", response.getDateStart());
        assertEquals("2020-12-31-23.59.59", response.getDateEnd());
        assertEquals("1", response.getRate());
        assertEquals("35,50 EUR", response.getPrice());

    }


    @Test
    public void when_date_is_20200614T1600_productId_is_35455_brandId_is_1_then_price_is_25_45_EUR() throws PriceNotFoundException{

        Mockito.when(priceRepository.findByDateAndProductIdAndBrandId(FormatUtil.dateParse("2020-06-14-16.00.00"),35455,1))
                .thenReturn(this.getPrices().stream().filter(price -> price.getStartDate().isBefore(FormatUtil.dateParse("2020-06-14-16.00.00"))
                && price.getEndDate().isAfter(FormatUtil.dateParse("2020-06-14-16.00.00")))
                .collect(Collectors.toList()));

        SearchPriceRequest request = SearchPriceRequest.builder().date(FormatUtil.dateParse("2020-06-14-16.00.00"))
                .productId(35455).brandId(1).build();

        SearchPriceResponse response = searchPriceUseCase.execute(request);

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-14-15.00.00", response.getDateStart());
        assertEquals("2020-06-14-18.30.00", response.getDateEnd());
        assertEquals("2", response.getRate());
        assertEquals("25,45 EUR", response.getPrice());

    }


    @Test
    public void when_date_is_20200614T2100_productId_is_35455_brandId_is_1_then_price_is_35_50_EUR() throws PriceNotFoundException{

        Mockito.when(priceRepository.findByDateAndProductIdAndBrandId(FormatUtil.dateParse("2020-06-14-21.00.00"),35455,1))
                .thenReturn(this.getPrices().stream().filter(price -> price.getStartDate().isBefore(FormatUtil.dateParse("2020-06-14-21.00.00"))
                && price.getEndDate().isAfter(FormatUtil.dateParse("2020-06-14-21.00.00")))
                .collect(Collectors.toList()));

        SearchPriceRequest request = SearchPriceRequest.builder().date(FormatUtil.dateParse("2020-06-14-21.00.00"))
                .productId(35455).brandId(1).build();

        SearchPriceResponse response = searchPriceUseCase.execute(request);

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-14-00.00.00", response.getDateStart());
        assertEquals("2020-12-31-23.59.59", response.getDateEnd());
        assertEquals("1", response.getRate());
        assertEquals("35,50 EUR", response.getPrice());

    }


    @Test
    public void when_date_is_20200615T1000_productId_is_35455_brandId_is_1_then_price_is_30_50_EUR() throws PriceNotFoundException{

        Mockito.when(priceRepository.findByDateAndProductIdAndBrandId(FormatUtil.dateParse("2020-06-15-10.00.00"),35455,1))
                .thenReturn(this.getPrices().stream().filter(price -> price.getStartDate().isBefore(FormatUtil.dateParse("2020-06-15-10.00.00"))
                && price.getEndDate().isAfter(FormatUtil.dateParse("2020-06-15-10.00.00")))
                .collect(Collectors.toList()));

        SearchPriceRequest request = SearchPriceRequest.builder().date(FormatUtil.dateParse("2020-06-15-10.00.00"))
                .productId(35455).brandId(1).build();

        SearchPriceResponse response = searchPriceUseCase.execute(request);

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-15-00.00.00", response.getDateStart());
        assertEquals("2020-06-15-11.00.00", response.getDateEnd());
        assertEquals("3", response.getRate());
        assertEquals("30,50 EUR", response.getPrice());

    }


    @Test
    public void when_date_is_20200616T2100_productId_is_35455_brandId_is_1_then_price_is_38_95_EUR() throws PriceNotFoundException{

        Mockito.when(priceRepository.findByDateAndProductIdAndBrandId(FormatUtil.dateParse("2020-06-16-21.00.00"),35455,1))
                .thenReturn(this.getPrices().stream().filter(price -> price.getStartDate().isBefore(FormatUtil.dateParse("2020-06-16-21.00.00"))
                && price.getEndDate().isAfter(FormatUtil.dateParse("2020-06-16-21.00.00")))
                .collect(Collectors.toList()));

        SearchPriceRequest request = SearchPriceRequest.builder().date(FormatUtil.dateParse("2020-06-16-21.00.00"))
                .productId(35455).brandId(1).build();

        SearchPriceResponse response = searchPriceUseCase.execute(request);

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-15-16.00.00", response.getDateStart());
        assertEquals("2020-12-31-23.59.59", response.getDateEnd());
        assertEquals("4", response.getRate());
        assertEquals("38,95 EUR", response.getPrice());

    }
    

    private List<Price> getPrices() {
        List<Price> listPrices = new ArrayList<>();

        listPrices.add(Price.builder().brandId("1").startDate(FormatUtil.dateParse("2020-06-14-00.00.00"))
                .endDate(FormatUtil.dateParse("2020-12-31-23.59.59")).priceList(1)
                .productId("35455").priority(0).amount(new Amount(Double.valueOf(35.50)))
                .currency(Currency.valueOf("EUR")).build());

        listPrices.add(Price.builder().brandId("1").startDate(FormatUtil.dateParse("2020-06-14-15.00.00"))
                .endDate(FormatUtil.dateParse("2020-06-14-18.30.00")).priceList(2)
                .productId("35455").priority(1).amount(new Amount(Double.valueOf(25.45)))
                .currency(Currency.valueOf("EUR")).build());

        listPrices.add(Price.builder().brandId("1").startDate(FormatUtil.dateParse("2020-06-15-00.00.00"))
                .endDate(FormatUtil.dateParse("2020-06-15-11.00.00")).priceList(3)
                .productId("35455").priority(1).amount(new Amount(Double.valueOf(30.50)))
                .currency(Currency.valueOf("EUR")).build());

        listPrices.add(Price.builder().brandId("1").startDate(FormatUtil.dateParse("2020-06-15-16.00.00"))
                .endDate(FormatUtil.dateParse("2020-12-31-23.59.59")).priceList(4)
                .productId("35455").priority(1).amount(new Amount(Double.valueOf(38.95)))
                .currency(Currency.valueOf("EUR")).build());

        return listPrices;
    }

}
