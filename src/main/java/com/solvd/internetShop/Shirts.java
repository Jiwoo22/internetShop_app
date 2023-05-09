package com.solvd.internetShop;

import exceptions.PriceException;

public final class Shirts extends MensClothing{

    public Shirts(String name, double price, double discountRate, String size, String color) throws PriceException {
        super(name, price, discountRate, size, color);
    }

    @Override
    public String getItemType(){
        return "Shirts";
    }

    @Override
    public String toString(){
        return  "Shirts [name=" + name + ", price=" + price + ", size=" + size +", color=" + color +  "]";
    }
}
