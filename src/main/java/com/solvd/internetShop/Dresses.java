package com.solvd.internetShop;

import exceptions.PriceException;

public final class Dresses extends WomensClothing {

    public Dresses(String name, double price, double discountRate,  String size, String color) throws PriceException {
        super(name, price, discountRate, size, color);
    }

    @Override
    public String getItemType() {
        return "Dresses";
    }

    @Override
    public String toString() {
        return "Dress [name=" + name + ", price=" + price + ", size=" + size + ", color=" + color + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + color.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Dresses other = (Dresses) obj;
        return this.color.equals(other.color);
    }
}
