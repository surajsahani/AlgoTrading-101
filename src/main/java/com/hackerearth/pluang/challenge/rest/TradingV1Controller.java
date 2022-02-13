package com.hackerearth.pluang.challenge.rest;

import com.hackerearth.pluang.challenge.api.StockService;
import com.hackerearth.pluang.challenge.model.Response;
import com.hackerearth.pluang.challenge.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/v1")
public class TradingV1Controller {

    @Autowired
    private StockService stockService;

    @GetMapping("{date}")
    public Response getMaxProfit(@PathVariable String date){
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return stockService.getProfitForSingleDate(localDate);
    }

    @GetMapping("hi")
    public String sayHi(){
        return "hi";
    }
}
