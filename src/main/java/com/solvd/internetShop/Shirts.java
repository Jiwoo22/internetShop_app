package com.solvd.internetShop;

import com.solvd.enums.ProductType;
import com.solvd.exceptions.PriceException;

import java.util.Objects;

public final class Shirts extends MensClothing{
    private String TYPE = ProductType.SHIRT.getType();

    public Shirts (String name, double price, double discountRate,
                  String size, String color) throws PriceException {
        super(name, price, discountRate, size, color);
    }

    @Override
    public String getItemType () {
        return TYPE;
    }

    @Override
    public String toString () {
        return  "Shirts [name=" + name + ", price=" + price
                + ", size=" + size +", color=" + color +  "]";
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shirts shirts = (Shirts) o;
        return Objects.equals(color, shirts.color) &&
                Objects.equals(name, shirts.name) &&
                Objects.equals(size, shirts.size);
    }

    @Override
    public int hashCode () {
        return Objects.hash(color, name, size);
    }
}
