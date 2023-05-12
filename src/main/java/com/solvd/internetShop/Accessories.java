package com.solvd.internetShop;

import com.solvd.enums.ProductType;
import com.solvd.exceptions.PriceException;
import com.solvd.exceptions.SizeException;

public class Accessories extends Product {
    protected String size;
    private String TYPE = ProductType.ACCESSORIES.getType();

    public Accessories (String name, double price, double discountRate,
           String size) throws SizeException, PriceException {

        super(name, price,  discountRate);

        if (size == null || size.isEmpty()) {
            throw new SizeException("Size cannot be null or empty");
        }

        this.size = size;
    }

    @Override
    public String getItemType () {
        return TYPE;
    }

    @Override
    public String toString () {
        return  "Accessories [name=" + name + ", " +
                "price=" + price + ", size=" + size + "]";
    }
}
