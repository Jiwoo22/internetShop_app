package com.solvd.internetShop;

import exceptions.BrandException;
import exceptions.ColorException;
import exceptions.PriceException;
import exceptions.SizeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws PriceException, BrandException,ColorException, SizeException, IOException {
        Customer customer1 = new Customer("Jiwoo", "jiwoo@example.com");
        Customer customer2 = new Customer("Amy", "amy@example.com");

        ArrayList<Product> product1 = new ArrayList<>();
        ArrayList<Product> product2 = new ArrayList<>();

        product1.add(new Dresses("Haley Maxi Dress", 99.99, 0, "Medium", "yellow"));
        product1.add(new Shirts("Flannel Shirt", 79.99, 0, "Large", "blue"));
        product1.add(new Shirts("Business Shirt", 59.99, 0, "Large", "white"));

        product2.add(new Bag("Herschel Supply Novel Duffle Bag", 59.99, 0, "Medium", "beige"));
        product2.add(new Running("Nike Air max", 119.99, 0, "5", "white", "Nike"));

        Order order1 = new Order(customer1, (List<Product>) product1);
        Order order2 = new Order(customer2, (List<Product>) product2);

        System.out.println("1st Order information");
        System.out.println("Customer: " + order1.getCustomer().getName() + " (" + order1.getCustomer().getEmail() + ")");
        System.out.println("Products: ");
        for (Product product : order1.getProducts()) {
            System.out.println(product);
        }
        System.out.println("Total price: $" + order1.getTotalPrice());

        System.out.println();
        System.out.println("2nd Order information");
        System.out.println("Customer: " + order2.getCustomer().getName() + " (" + order2.getCustomer().getEmail() + ")");
        System.out.println("Products: ");
        for (Product product : order2.getProducts()) {
            System.out.println(product);
        }
        System.out.println("Total price: $" + order2.getTotalPrice());

        System.out.println("------------------------------------");

        Running shoes1 = new Running("Running Shoes", 99.99, 0, "L", "White", "Nike");
        Running shoes2 = new Running("Running Shoes", 99.99, 0, "L", "White", "Nike");

        System.out.println(shoes1.equals(shoes2));

        System.out.println("shoes1 hashCode() : " + shoes1.hashCode());
        System.out.println("shoes2 hashCode() : " + shoes2.hashCode());

        System.out.println("------------------------------------");
        Product dress = new Dresses("Red Dress", 100.0, 0, "M", "Red");
        Product shirt = new Shirts("Blue Shirt", 50.0, 0, "L", "Blue");

        displayItemDetails(dress);
        displayItemDetails(shirt);

        System.out.println("---------------priceException---------------------");

        Product product3 = null;
        try {
            product3 = new Bag("backpack", -1, 0, "L", "black");
        } catch (PriceException e) {
            e.printStackTrace();
        }

        product3.setPrice(1);
        logger.debug("the product price is set to :" + product3.price);

        System.out.println("------------------------------------");

        try{
            Shoes shoes = new Running("Running Sneaker", 101.99, 0, "L", "While", "Nike");
        } catch (PriceException e){
            System.out.println("Error: " + e.getMessage());
        } catch (SizeException e){
            System.out.println("Error: " + e.getMessage());
        } catch (ColorException e){
            System.out.println("Error: " + e.getMessage());
        } catch (BrandException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("----------------hashSet--------------------");

        Set<String> uniqueProductTypes = new HashSet<>();

        for (Product product : product1) {
            uniqueProductTypes.add(product.getItemType());
        }

        for (Product product : product2) {
            uniqueProductTypes.add(product.getItemType());
        }

        System.out.println("Unique product types: " + uniqueProductTypes);

        System.out.println("--------------hashMap----------------------");

        Map<String, Integer> productTypeCount = new HashMap<>();

        for (Product product: product1) {
            String itemType = product.getItemType();
            if(productTypeCount.containsKey(itemType)){
                productTypeCount.put(itemType, productTypeCount.get(itemType) + 1);
            } else {
                productTypeCount.put(itemType, 1);
            }
        }

        for (Product product: product2) {
            String itemType = product.getItemType();
            if(productTypeCount.containsKey(itemType)){
                productTypeCount.put(itemType, productTypeCount.get(itemType) + 1);
            } else {
                productTypeCount.put(itemType, 1);
            }
        }

        System.out.println("Product Type Count: " + productTypeCount);

        System.out.println("----------------TreeMap--------------------");

        List<Product> allProducts = new ArrayList<>();
        allProducts.addAll(product1);
        allProducts.addAll(product2);

        TreeMap<Double, List<Product>> sortedProductsByPrice = sortProductsByPrice(allProducts);
        System.out.println("Products sorted by price : ");
        for(Map.Entry<Double, List<Product>> entry: sortedProductsByPrice.entrySet()){
            System.out.println("Price: " + entry.getKey());
            for(Product product : entry.getValue()){
                System.out.println("\t" + product);
            }
        }

        System.out.println("--------------customLinkedList----------------------");

        Customer customer3 = new Customer("Jiwoo", "jiwoo@example.com");

        CustomLinkedList<Product> product4 = new CustomLinkedList<>();
        product4.add(new Running("Birkenstock sandals", 66.00, 0, "5", "black", "Birkenstock"));
        product4.add(new Running("Converse sneakers", 65.00, 0, "5", "black", "Converse"));

        System.out.println("Customer: " + customer3.getName() + " (" + customer3.getEmail() + ")");
        System.out.println("Products: " );
        for(int i = 0; i < product4.size(); i++){
            System.out.println("\t" + product4.get(i));
        }

    }


    public static void displayItemDetails(Product item) {
        System.out.println(item);
        System.out.println("Item type: " + item.getItemType());
        System.out.println("Price: " + item.calculatePrice());
    }


    public static TreeMap<Double, List<Product>> sortProductsByPrice(List<Product> products) {
        TreeMap<Double, List<Product>> sortedProducts = new TreeMap<>();

        for(Product product: products) {
            double price = product.getPrice();
            if(!sortedProducts.containsKey(price)){
                sortedProducts.put(price, new ArrayList<>());
            }
            sortedProducts.get(price).add(product);
        }

        return sortedProducts;
    }

}
