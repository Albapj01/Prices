package com.example.exercise.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.exercise.application.search_price.SearchPriceUseCase;
import com.example.exercise.domain.repositories.PriceRepository;
import com.example.exercise.domain.services.PriceService;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public PriceService priceService(PriceRepository priceRepository) {
        return new PriceService(priceRepository);
    }

    @Bean
    public SearchPriceUseCase searchPriceUseCase(PriceService priceService) {
        return new SearchPriceUseCase(priceService);
    }

}
