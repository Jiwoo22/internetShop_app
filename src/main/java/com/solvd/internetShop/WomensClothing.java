package com.solvd.internetShop;

import exceptions.PriceException;

public class WomensClothing extends Clothing{

    public WomensClothing(String name, double price, double discountRate, String size, String color) throws PriceException {
        super(name, price, discountRate, size, color);
    }

    @Override
    public String getItemType(){
        return "Womens Clothing";
    }

    @Override
    public String toString(){
        return  "Womens Clothing [name=" + name + ", price=" + price + ", size=" + size + "]";
    }
}
