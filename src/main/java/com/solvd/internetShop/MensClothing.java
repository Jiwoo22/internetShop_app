package com.solvd.internetShop;

import com.solvd.enums.ProductType;
import com.solvd.exceptions.PriceException;

public class MensClothing extends Clothing{
    private String TYPE = ProductType.MEN_CLOTHING.getType();

    public MensClothing (String name, double price, double discountRate,
                        String size, String color) throws PriceException {
        super(name, price, discountRate, size, color);
    }

    @Override
    public String getItemType () {
        return TYPE;
    }

    @Override
    public String toString () {
        return  "Mens Clothing [name="
                + name + ", price=" + price + ", size=" + size +  "]";
    }
}
