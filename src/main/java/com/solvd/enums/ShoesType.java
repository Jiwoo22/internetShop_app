package com.solvd.enums;

public enum ShoesType {
    RUNNING("Running Shoes"),
    CASUAL("Casual Shoes"),
    FORMAL("Formal Shoes"),
    SPORTS("Sports Shoes"),
    BOOTS("Boots");

    private String type;

    ShoesType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
