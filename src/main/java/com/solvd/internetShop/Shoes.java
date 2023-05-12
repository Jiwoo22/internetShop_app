package com.solvd.internetShop;

import com.solvd.enums.ProductType;
import com.solvd.exceptions.BrandException;
import com.solvd.exceptions.ColorException;
import com.solvd.exceptions.PriceException;
import com.solvd.exceptions.SizeException;

import java.util.Objects;

public class Shoes extends Product implements Sizeable, Category, Brandable, Colorable {
    protected String size;
    protected String brand;
    protected String color;
    protected String shoesType;
    private String TYPE = ProductType.SHOES.getType();
    private String CATEGORY = "Footwear";

    public Shoes(String name, double price, double discountRate,
                 String size, String brand, String color, String shoesType)
            throws PriceException, SizeException, BrandException, ColorException {
        super(name, price, discountRate);

        if (size == null || size.isEmpty()) {
            throw new SizeException("Size cannot be null or empty");
        }
        if (brand == null || brand.isEmpty()) {
            throw new BrandException("Brand cannot be null or empty");
        }

        this.size = size;
        this.brand = brand;
        this.color = color;
        this.shoesType = shoesType;
    }

    public String getShoesType () {
        return shoesType;
    }

    public void setShoesType (String shoesType) {
        this.shoesType = shoesType;
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
    public String getSize (){
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
    public String getCategory () {
        return CATEGORY;
    }

    @Override
    public String getColor () {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString (){
        return  "Shoes [name=" + name + ", price="
                + price + ", size=" + size +", color=" + color
                + ", type=" + shoesType + "]";
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoes shoes = (Shoes) o;
        return Objects.equals(color, shoes.color) &&
                Objects.equals(name, shoes.name) &&
                Objects.equals(size, shoes.size) &&
                Objects.equals(brand, shoes.brand);
    }

    @Override
    public int hashCode () {
        return Objects.hash(color, name, size, brand);
    }
}
