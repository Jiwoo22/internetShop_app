package com.solvd.internetShop;

import com.solvd.enums.OrderStatus;
import com.solvd.lambda.Filter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Order {
    private Customer customer;
    private List<Product> products;
    private Queue<Product> processingQueue;
    private static int orderCount = 0;
    private OrderStatus status;

    public Order (Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
        this.processingQueue = new LinkedList<>(products);
        this.status = OrderStatus.PENDING;
        orderCount++;
    }

    public OrderStatus getStatus () {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public static int getOrderCount () {
        return orderCount;
    }

    public Customer getCustomer () {
        return customer;
    }

    public void setCustomer (Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts () {
        return products;
    }

    public void setProducts (List<Product> products) {
        this.products = products;
    }

    public double getTotalPrice () {
        double total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }

    public Product getNextProduct () {
        return processingQueue.poll();
    }

    public List<Product> getProductsWithFilter (Filter<Product, Boolean> filterProduct) {
        List<Product> productsFiltered = new ArrayList<>();
        for (Product prod : products) {
            if (filterProduct.filter(prod)) {
                productsFiltered.add(prod);
            }
        }
        return productsFiltered;
    }
}
