package com.solvd.internetShop;

import exceptions.PriceException;

public class MensClothing extends Clothing{

    public MensClothing(String name, double price, double discountRate, String size, String color) throws PriceException {
        super(name, price, discountRate, size, color);
    }

    @Override
    public String getItemType(){
        return "Mens Clothing";
    }

    @Override
    public String toString(){
        return  "Mens Clothing [name=" + name + ", price=" + price + ", size=" + size +  "]";
    }
}
