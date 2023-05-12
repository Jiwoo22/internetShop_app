package com.solvd.internetShop;

import com.solvd.enums.ProductType;
import com.solvd.exceptions.PriceException;

import java.util.Objects;

public final class Dresses extends WomenClothing {
    private String TYPE = ProductType.DRESSES.getType();

    public Dresses (String name, double price, double discountRate,
                    String size, String color) throws PriceException {
        super(name, price, discountRate, size, color);
    }

    @Override
    public String getItemType () {
        return TYPE;
    }

    @Override
    public String toString () {
        return "Dress [name=" + name + ", price=" + price
                + ", size=" + size + ", color=" + color + "]";
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dresses dresses = (Dresses) o;
        return Objects.equals(color, dresses.color) &&
                Objects.equals(name, dresses.name) &&
                Objects.equals(size, dresses.size);
    }

    @Override
    public int hashCode () {
        return Objects.hash(color, name, size);
    }
}
