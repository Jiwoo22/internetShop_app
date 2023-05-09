package com.solvd.internetShop;

import exceptions.PriceException;

public class Accessories extends Product{
    protected String size;

    public Accessories(String name, double price, double discountRate, String size) throws PriceException {
        super(name, price,  discountRate);
        this.size = size;
    }

    @Override
    public String getItemType(){
        return "Accessories";
    }

    @Override
    public String toString(){
        return  "Accessories [name=" + name + ", price=" + price + ", size=" + size + "]";
    }
}
