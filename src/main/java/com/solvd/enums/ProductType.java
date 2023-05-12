package com.solvd.enums;

public enum ProductType {
    DRESSES("Dresses"),
    BAG("Bag"),
    SHOES("Shoes"),
    SHIRT("Shirt"),
    CLOTHING("Clothing"),
    MEN_CLOTHING("Men's clothing"),
    WOMEN_CLOTHING("Women's clothing"),
    ACCESSORIES("Accessories");

    private String type;

    ProductType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
