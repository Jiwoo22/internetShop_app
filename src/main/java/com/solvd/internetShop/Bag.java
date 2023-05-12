package com.solvd.internetShop;

import com.solvd.enums.ProductType;
import com.solvd.exceptions.BrandException;
import com.solvd.exceptions.ColorException;
import com.solvd.exceptions.PriceException;
import com.solvd.exceptions.SizeException;

public class Bag extends Accessories implements Brandable {
    protected String color;
    protected String brand;
    protected String bagType;
    private String TYPE = ProductType.BAG.getType();

    public Bag (String name, double price, double discountRate,
                String size, String color, String brand, String bagType)
            throws PriceException, SizeException, ColorException, BrandException {

        super(name, price, discountRate, size);

        if (color == null || size.isEmpty()) {
            throw new ColorException("Color cannot be null or empty");
        }

        if (brand == null || brand.isEmpty()) {
            throw new BrandException("Brand cannot be null or empty");
        }

        this.color = color;
        this.brand = brand;
        this.bagType = bagType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getBrand () {
        return brand;
    }

    @Override
    public void setBrand (String brand) {
        this.brand = brand;
    }

    @Override
    public String getItemType (){
        return TYPE;
    }

    @Override
    public String toString () {
        return  "Bag [name=" + name + ", price=" + price + ", size="
                + size +", color=" + color +  "]";
    }
}
