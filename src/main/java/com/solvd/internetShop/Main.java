package com.solvd.internetShop;

import com.solvd.enums.*;
import com.solvd.exceptions.BrandException;
import com.solvd.exceptions.ColorException;
import com.solvd.exceptions.PriceException;
import com.solvd.exceptions.SizeException;
import com.solvd.utils.ReadingFile;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.*;
import java.io.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main (String[] args)
            throws PriceException, BrandException, ColorException, SizeException, IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        final String INPUT_FILE = "src/main/resources/sample.txt";
        final File OUTPUT_FILE = new File("src/main/resources/output.txt");


        Customer customer1 = new Customer("Jiwoo", "jiwoo@example.com");
        Customer customer2 = new Customer("Amy", "amy@example.com");

        ArrayList<Product> product1 = new ArrayList<>();
        ArrayList<Product> product2 = new ArrayList<>();

        product1.add(new Dresses("Haley Maxi Dress",
                99.99, 0, "Medium", "yellow"));
        product1.add(new Shirts("Flannel Shirt",
                79.99, 0, "Large", "blue"));
        product1.add(new Shirts("Business Shirt",
                59.99, 0, "Large", "white"));
        product1.add(new Shoes("Nike Air max", 119.99,
                0, "5", "white", "Nike",
                ShoesType.CASUAL.getType()));

        product2.add(new Bag("Herschel Supply Novel Duffle Bag",
                59.99, 0, "Medium", "beige",
                "Herschel", BagType.DUFFLE.getType()));
        product2.add(new Shoes("Nike Air max", 119.99,
                0, "5", "white", "Nike",
                ShoesType.CASUAL.getType()));

        Order order1 = new Order(customer1, (List<Product>) product1);
        Order order2 = new Order(customer2, (List<Product>) product2);

        System.out.println("1st Order information");
        System.out.println("Customer: " + order1.getCustomer().getName() + " ("
                            + order1.getCustomer().getEmail() + ")");
        System.out.println("Products: ");
        for (Product product : order1.getProducts()) {
            System.out.println(product);
        }
        System.out.println("Total price: $" + order1.getTotalPrice());

        System.out.println();
        System.out.println("2nd Order information");
        System.out.println("Customer: " + order2.getCustomer().getName()
                            + " (" + order2.getCustomer().getEmail() + ")");
        System.out.println("Products: ");
        for (Product product : order2.getProducts()) {
            System.out.println(product);
        }
        System.out.println("Total price: $" + order2.getTotalPrice());


        // HashCode examples
        System.out.println("-------------------------HashCode-----------------------------");
        Shoes shoes1 = new Shoes("Running Shoes", 99.99,
                0, "L", "White", "Nike", ShoesType.RUNNING.getType());
        Shoes shoes2 = new Shoes("Running Shoes", 99.99,
                0, "L", "White", "Nike", ShoesType.RUNNING.getType());

        System.out.println("shoes1 = " + shoes1);
        System.out.println("shoes1 = " + shoes2);

        System.out.println("shoes1 == shoes2 ? " + shoes1.equals(shoes2));

        System.out.println("shoes1 hashCode() : " + shoes1.hashCode());
        System.out.println("shoes2 hashCode() : " + shoes2.hashCode());


        // try-catch & log message examples
        System.out.println("---------------------priceException---------------------");
        Product product3 = null;

        try {
            product3 = new Bag("backpack", 1, 0,
                    "L", "black", "nike",
                    BagType.BACKPACK.getType());
        } catch (PriceException e) {
            e.printStackTrace();
        }

        product3.setPrice(1);
        logger.debug("the product price is set to :" + product3.price);


        // Handling exepctions using try-catch
        System.out.println("-----------------------try-catch-------------------------");

        try{
            Shoes shoes = new Shoes("Running Sneaker", 101.99, 0,
                    "L", "While", "Nike", ShoesType.RUNNING.getType());
        } catch (PriceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SizeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ColorException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (BrandException e) {
            System.out.println("Error: " + e.getMessage());
        }


        // hashSet example
        System.out.println("----------------------------hashSet--------------------------");
        Set<String> uniqueProductTypes = new HashSet<>();

        for (Product product : product1) {
            uniqueProductTypes.add(product.getItemType());
        }

        for (Product product : product2) {
            uniqueProductTypes.add(product.getItemType());
        }

        System.out.println("Unique product types: " + uniqueProductTypes);


        // hashMap example
        System.out.println("--------------------------hashMap----------------------------");
        Map<String, Integer> productTypeCount = new HashMap<>();

        for (Product product : product1) {
            String itemType = product.getItemType();
            if (productTypeCount.containsKey(itemType)) {
                productTypeCount.put(itemType, productTypeCount.get(itemType) + 1);
            } else {
                productTypeCount.put(itemType, 1);
            }
        }

        for (Product product : product2) {
            String itemType = product.getItemType();
            if (productTypeCount.containsKey(itemType)) {
                productTypeCount.put(itemType, productTypeCount.get(itemType) + 1);
            } else {
                productTypeCount.put(itemType, 1);
            }
        }

        System.out.println("Product Type Count: " + productTypeCount);


        // TreeMap example
        System.out.println("----------------------------TreeMap--------------------------");
        List<Product> allProducts = new ArrayList<>();
        allProducts.addAll(product1);
        allProducts.addAll(product2);

        TreeMap<Double, List<Product>> sortedProductsByPrice
                = sortProductsByPrice(allProducts);

        System.out.println("Products sorted by price : ");
        for (Map.Entry<Double, List<Product>> entry : sortedProductsByPrice.entrySet()) {
            System.out.println("Price: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("\t" + product);
            }
        }


        // custom LinkedList example
        System.out.println("--------------------------customLinkedList----------------------------");
        Customer customer3 = new Customer("Jiwoo", "jiwoo@example.com");

        CustomLinkedList<Product> product4 = new CustomLinkedList<>();
        product4.add(new Shoes("Birkenstock sandals", 66.00, 0,
                "5", "black", "Birkenstock",
                ShoesType.RUNNING.getType()));
        product4.add(new Shoes("Converse sneakers", 65.00, 0,
                "5", "black", "Converse",
                ShoesType.RUNNING.getType()));

        System.out.println("Customer: " + customer3.getName() + " ("
                            + customer3.getEmail() + ")");
        System.out.println("Products: " );
        for(int i = 0; i < product4.size(); i++){
            System.out.println("\t" + product4.get(i));
        }


        // Read test from file and calculate the number of the unique words
        System.out.println("--------------------------countUniqueWords----------------------");
        int uniqueWordsCount = ReadingFile.getUniqueWordCountInFile(INPUT_FILE);
        FileUtils.writeStringToFile(OUTPUT_FILE, "Unique word count: " + uniqueWordsCount);
        String fileContents = FileUtils.readFileToString(OUTPUT_FILE, Charset.forName("UTF-8"));
        System.out.println(fileContents);


        // Enums examples
        System.out.println("--------------------------Enums-------------------------------");
        Shoes shoes3 = new Shoes("Converse sneakers", 65.00, 0,
                "5", "black", "Converse",
                ShoesType.RUNNING.getType());
        System.out.println(shoes3);

        Bag newBag = new Bag("Herschel Supply Novel Duffle Bag",
                59.99, 0, Size.LARGE.getSize(), Color.BLACK.getColor(),
                "Herschel", BagType.DUFFLE.getType());
        System.out.println(newBag);

        System.out.println("the current status of order1 is " + order1.getStatus());
        order1.setStatus(OrderStatus.CANCELED);
        System.out.println("the current status of order1 is " +  order1.getStatus());


        // 3 custom Lambda functions with generics
        System.out.println("---------------------lambda functions to SORT---------------------");
        // Lambda function to SORT Products by Name
        List<Product> products = new ArrayList<>();
        products.add(new Shoes("Converse sneakers", 65.00, 0,
                "5", "black", "Converse",
                ShoesType.RUNNING.getType()));
        products.add(new Bag("Herschel Supply Novel Duffle Bag",
                59.99, 0, Size.LARGE.getSize(), Color.BLACK.getColor(),
                "Herschel", BagType.DUFFLE.getType()));
        products.add(new Dresses("Haley Maxi Dress",
                99.99, 0, Size.SMALL.getSize(), Color.BLUE.getColor()));

        products.sort((Product p1, Product p2) -> {
            return p1.getName().compareTo(p2.getName());
        });
        System.out.println(products);

        System.out.println("---------------------lambda functions to Filter only shirts---------------------");
        System.out.println(order1.getProductsWithFilter(product -> product.getItemType() == ProductType.SHIRT.getType()));

        // Lambda function to Filter Products by Price
        System.out.println("---------------------lambda functions to Filter by price---------------------");
        Shoes shoes4 = new Shoes("Converse sneakers", 65.00, 0,
                "5", "black", "Converse",
                ShoesType.RUNNING.getType());
        Predicate<Product> filterByPrice = (product) -> product.getPrice() < 100;
        System.out.println("is the shoes less than 100 ? " + filterByPrice.test(shoes4));


        // Lambda function to Map Products by its name
        System.out.println("---------------------lambda functions to MAP---------------------");
        Function<Product, String> mapByName = (product) -> product.getName();
        System.out.println(mapByName.apply(shoes4));


        // 5 lambda functions from java.util.function package
        System.out.println("---------------------5 lambda functions---------------------");
        Predicate<Product> isDiscounted = prod -> prod.DISCOUNT_RATE > 0;
        Consumer<Order> printMessage = order -> System.out.println("an order is made");
        Function<Product, String> convertToString = prod -> String.valueOf(prod.getPrice());
        Supplier<Customer> supplier = () -> new Customer("Amy", "amy@gmail.com");
        UnaryOperator<Product> increasePrice = prod -> {
            try {
                prod.setPrice(prod.getPrice() * 1.05);
            } catch (PriceException e) {
                e.printStackTrace();
            }
            return prod;
        };


        // Add 7 collection streaming in the hierarchy with terminal and non-terminal operations.
        System.out.println("---------------------7 collection streaming--------------------");
        order1.getProducts().forEach(System.out::println);

        List<Product> filteredProduct = order1.getProducts().stream()
                .filter((Product product) -> product.getName().startsWith("F"))
                .collect(Collectors.toList());
        System.out.println("product that starts with F: " + filteredProduct);

        List<Double> prices = order1.getProducts().stream()
                .map((product) -> product.getPrice())
                .collect(Collectors.toList());
        System.out.println("prices: " + prices);

        System.out.println("Average price: " + order1.getProducts().stream()
                .mapToDouble(Product::getPrice).average().getAsDouble());

        System.out.println("First product: " + order1.getProducts().stream().findFirst());

        System.out.println("The number of the products: " + order1.getProducts().stream().count());

        System.out.println("Product types: " + order1.getProducts().stream()
                .map(Product::getItemType).collect(Collectors.toSet()));

        order1.getProducts().stream()
                .sorted(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }).forEach(System.out::println);


        // Using reflection extract information about fields, constructors, methods.
        // Create customer and call setEmail method using the only reflection.
        Class classR = Class.forName("com.solvd.internetShop.Customer");

        System.out.println(Stream.of(classR.getDeclaredMethods()).map(Method::getName)
                .collect(Collectors.toList()));

        Customer customer4 = new Customer("Tom", "tom@yahoo.com");
        System.out.println(customer4);

        Method setEmailMethod = classR.getDeclaredMethod("setEmail", String.class );
        setEmailMethod.invoke(customer4, "tom@gmail.com");
        System.out.println(customer4);

    }




    public static void displayItemDetails (Product item) {
        System.out.println(item);
        System.out.println("Item type: " + item.getItemType());
        System.out.println("Price: " + item.calculatePrice());
    }


    public static TreeMap<Double, List<Product>> sortProductsByPrice (List<Product> products) {
        TreeMap<Double, List<Product>> sortedProducts = new TreeMap<>();

        for (Product product : products) {
            double price = product.getPrice();
            if (!sortedProducts.containsKey(price)) {
                sortedProducts.put(price, new ArrayList<>());
            }
            sortedProducts.get(price).add(product);
        }

        return sortedProducts;
    }

}
