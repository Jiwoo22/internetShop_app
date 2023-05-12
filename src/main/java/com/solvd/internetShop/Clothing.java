package com.solvd.internetShop;

import com.solvd.enums.ProductType;
import com.solvd.exceptions.PriceException;

public abstract class Clothing extends Product
        implements Category, Colorable, Sizeable {

    protected String size;
    protected String color;
    private String TYPE = ProductType.CLOTHING.getType();
    public Clothing (String name, double price, double discountRate,
                        String size, String color) throws PriceException {
        super(name, price, discountRate);
        this.size = size;
        this.color = color;
    }

    @Override
    public String getSize () {
        return size;
    }

    @Override
    public void setSize (String size) {
        this.size = size;
    }

    @Override
    public String getItemType () {
        return TYPE;
    }

    @Override
    public String toString () {
            return  "Clothing [name=" + name + ", price="
                    + price + ", size=" + size + "]";
    }

    public String getCategory () {
        return "Clothing";
    }

    @Override
    public double calculatePrice () {
        return price;
    }

    @Override
    public String getColor () {
        return color;
    }

    @Override
    public void setColor (String color) {
        this.color = color;
    }
}
