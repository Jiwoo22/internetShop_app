package com.solvd.internetShop;

import exceptions.PriceException;

public class Bag extends Accessories implements Brandable{
    protected String color;
    protected String brand;

    public Bag(String name, double price, double discountRate, String size, String color) throws PriceException {
        super(name, price, discountRate, size);
        this.color = color;
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getItemType(){
        return "Bag";
    }

    @Override
    public String toString(){
        return  "Bag [name=" + name + ", price=" + price + ", size=" + size +", color=" + color +  "]";
    }
}
