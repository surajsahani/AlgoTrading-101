package com.example.algotrading.api;


import java.time.LocalDate;

import com.example.algotrading.model.Response;


public interface StockService {

    Response getProfitForSingleDate(LocalDate date);

}
