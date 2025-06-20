package com.jdk.handson.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductDBUtils{
    public static List<Product> fetchProductList(){
        Product p1 = new Product.ProductBuilder().name("Laptop").category("Electronics").price(1000).build();

        Product p2 = new Product.ProductBuilder().name("TV").category("Electronics").price(1500).build();


        Product p3 = new Product.ProductBuilder().name("Sofa").category("Furniture").price(700).build();


        Product p4 = new Product.ProductBuilder().name("Table").category("Furniture").price(300).build();

        Product p5 = new Product.ProductBuilder().name("Lamp").category("Home Decor").price(500).build();

        return Collections.unmodifiableList(Arrays.asList(p1,p2,p3,p4,p5));
    }
}
