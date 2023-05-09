package com.solvd.internetShop;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Order {
    private Customer customer;
    private List<Product> products;
    private Queue<Product> processingQueue;

    public Order(Customer customer, List<Product> products){
        this.customer = customer;
        this.products = products;
        this.processingQueue = new LinkedList<>(products);
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public List<Product> getProducts(){
        return products;
    }

    public void setProducts(List<Product> products){
        this.products = products;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }

    public Product getNextProduct(){
        return processingQueue.poll();
    }
}
