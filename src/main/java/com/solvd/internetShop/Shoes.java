package com.solvd.internetShop;

import exceptions.BrandException;
import exceptions.PriceException;
import exceptions.SizeException;

public class Shoes extends Product implements Sizeable, Category, Brandable {
    protected String size;
    protected String brand;

    public Shoes(String name, double price, double discountRate,  String size, String brand) throws PriceException, SizeException, BrandException {
        super(name, price, discountRate);

        if(size == null || size.isEmpty()){
            throw new SizeException("Size cannot be null or empty");
        }
        if(brand == null || brand.isEmpty()){
            throw new BrandException("Brand cannot be null or empty");
        }

        this.size = size;
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
    public String getSize(){
        return size;
    }

    @Override
    public void setSize(String size){
        this.size = size;
    }

    @Override
    public String getItemType(){
        return "Shoes";
    }

    @Override
    public String getCategory() {
        return "Footwear";
    }

    @Override
    public String toString(){
        return  "Shoes [name=" + name + ", price=" + price + ", size=" + size +  "]";
    }

}
