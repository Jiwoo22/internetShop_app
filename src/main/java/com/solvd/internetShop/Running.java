package com.solvd.internetShop;

import exceptions.BrandException;
import exceptions.ColorException;
import exceptions.PriceException;
import exceptions.SizeException;

import java.util.Objects;

public class Running extends Shoes{

    private String color;

    public Running(String name, double price,double discountRate, String size, String color, String brand) throws PriceException, SizeException, BrandException, ColorException {
        super(name, price, discountRate, size, brand);
        if (color == null || color.isEmpty()) {
            throw new ColorException("Color cannot be null or empty");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }


    @Override
    public String getItemType(){
        return "Running Shoes";
    }

    @Override
    public String toString(){
        return  "Running Shoes [name=" + name + ", price=" + price + ", size=" + size +", color=" + color +  "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Running running = (Running) o;
        return Objects.equals(color, running.color) &&
                Objects.equals(name, running.name) &&
                Objects.equals(size, running.size) &&
                Objects.equals(price, running.price) &&
                Objects.equals(brand, running.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, name, size, price, brand);
    }
}
