package com.solvd.internetShop;

import com.solvd.exceptions.PriceException;

public abstract class Product implements PriceCalculatable{
    protected String name;
    protected double price;
    protected final double DISCOUNT_RATE;

    public Product(String name, double price, double discountRate) throws PriceException {
        if(price < 0){
            throw new PriceException("A Product object can't have a negative price :" + price);
        } else {
            this.price = price;
        }

        this.name = name;
        this.DISCOUNT_RATE = discountRate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws PriceException {
        if(price < 0){
            throw new PriceException("price can't be negative");
        } else {
            this.price = price;
        }
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    protected abstract String getItemType();

    @Override
    public String toString(){
        return "Product [name = " + name + ", price = " + price + "]";
    }
}


