package com.solvd.internetShop;

import com.solvd.enums.ProductType;
import com.solvd.exceptions.PriceException;

public class WomenClothing extends Clothing{
    private String TYPE = ProductType.WOMEN_CLOTHING.getType();

    public WomenClothing(String name, double price, double discountRate,
                         String size, String color) throws PriceException {
        super(name, price, discountRate, size, color);
    }

    @Override
    public String getItemType () {
        return TYPE;
    }

    @Override
    public String toString () {
        return  "Womens Clothing [name=" + name
                + ", price=" + price + ", size=" + size + "]";
    }
}
