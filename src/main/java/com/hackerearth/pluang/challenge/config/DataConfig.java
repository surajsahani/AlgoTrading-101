package com.hackerearth.pluang.challenge.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerearth.pluang.challenge.model.Stock;
import com.hackerearth.pluang.challenge.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.List;

@Configuration
public class DataConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataConfig.class);

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ObjectMapper mapper;

    @Bean
    public String loadData(){

        File file = new File("src/main/resources/data/AAPLbdc2518.json");
        try {
            List<Stock> stocks = mapper.readValue(file, new TypeReference<List<Stock>>() {});
            stockRepository.saveAllAndFlush(stocks);
            LOGGER.info("Loaded initial data to database");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
