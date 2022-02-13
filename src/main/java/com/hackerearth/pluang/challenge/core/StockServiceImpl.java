package com.hackerearth.pluang.challenge.core;

import com.hackerearth.pluang.challenge.api.StockService;
import com.hackerearth.pluang.challenge.model.Response;
import com.hackerearth.pluang.challenge.model.Stock;
import com.hackerearth.pluang.challenge.model.enums.Strategy;
import com.hackerearth.pluang.challenge.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Response getProfitForSingleDate(LocalDate date) {
        Optional<Stock> optionalStock= stockRepository.findByDateIs(date);

        Stock stock = null;
        if(optionalStock.isPresent()){
            stock = optionalStock.get();
        } else {
            throw new RuntimeException("No stock found for the date " + date);
        }

        Double openHighDiff = stock.getOpen() - stock.getHigh();
        Double openLowDiff = stock.getOpen() - stock.getLow();
        Double openCloseDiff = stock.getOpen() - stock.getClose();

        Response response = new Response();

        Double diff = 0d;
        if(Math.abs(openHighDiff) > Math.abs(openLowDiff) && Math.abs(openHighDiff) > Math.abs(openCloseDiff) ){
            response.setProfit(Math.abs(openHighDiff));
            response.setTargetTime("High");
            diff = openHighDiff;
        }
        else if(Math.abs(openLowDiff) > Math.abs(openHighDiff) && Math.abs(openLowDiff) > Math.abs(openCloseDiff) ){
            response.setProfit(Math.abs(openLowDiff));
            response.setTargetTime("Low");
            diff = openLowDiff;
        }
        else if(Math.abs(openCloseDiff) >= Math.abs(openLowDiff) && Math.abs(openCloseDiff) >= Math.abs(openHighDiff) ){
            response.setProfit(Math.abs(openCloseDiff));
            response.setTargetTime("Close");
            diff = openCloseDiff;
        }

        if(diff < 0){
            response.setStrategy(Strategy.LONG);
        }else {
            response.setStrategy(Strategy.SHORT);
        }

        return response;
    }
}
