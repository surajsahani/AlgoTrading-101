package com.hackerearth.pluang.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackerearth.pluang.challenge.model.enums.Strategy;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class Response {

    @JsonProperty("Strategy")
    private Strategy strategy;
    @JsonProperty("TargetTime")
    private String targetTime;
    @JsonProperty("Profit")
    private Double profit;

    public void setProfit(Double profit) {
        this.profit = new BigDecimal(profit).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
}
