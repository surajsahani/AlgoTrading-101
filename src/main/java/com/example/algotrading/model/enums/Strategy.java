package com.example.algotrading.model.enums;


public enum Strategy {

    SHORT("Short"),
    LONG("Long");

    private String value;

    Strategy(String value){
        this.value = value;
    }

    public String getValue(){return this.value;}

}
