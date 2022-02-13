package com.hackerearth.pluang.challenge.api;

import com.hackerearth.pluang.challenge.model.Response;

import java.time.LocalDate;

public interface StockService {

    Response getProfitForSingleDate(LocalDate date);

}
