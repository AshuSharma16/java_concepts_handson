package com.jdk.handson.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class PlayWithStreamOprations{
    public static void main(String[] args){

        //1. create Immutable list
        final List<String> collect = Stream.of("red","green",null).collect(collectingAndThen(toList(),Collections::unmodifiableList));
       // collect.add("yellow");
        System.out.println(collect);

        final List<String> unmodifiableList = Collections.unmodifiableList(Arrays.asList("red","green",null));
        //unmodifiableList.add("Orange");
        
        //2  create Modifiable List
        final List<String> modifiableList = Stream.of("red","green",null).collect(toList());
        modifiableList.set(2, "Maroon");
        System.out.println(modifiableList);

        //3, Partitioning : Seprate Product into cheap and expensive

        final Map<Boolean, List<Product>> productPartitioning = ProductDBUtils.fetchProductList().stream().collect(Collectors.partitioningBy(product -> product.getPrice() > 1000));
        System.out.println("productPartitioning : -" +productPartitioning);

        //4. Summary Statistics
        // sum , max, min , average , count ( 5 metrics)

        final Map<String, IntSummaryStatistics> summaryStatistics1 = ProductDBUtils.fetchProductList().stream().collect(Collectors.groupingBy(Product::getCategory
                ,Collectors.summarizingInt(Product::getPrice)));
        System.out.println("summaryStatistics1 - "+summaryStatistics1);
        final IntSummaryStatistics summaryStatistics2 =
                ProductDBUtils.fetchProductList().stream().collect(Collectors.summarizingInt(Product::getPrice));
        System.out.println("summaryStatistics2 - "+summaryStatistics2);

        // 5. Find max element from a list of integer

        List<Integer> numbers = Arrays.asList(2,4,6,12,43,22,7);
        final Optional<Integer> max = numbers.stream().max(Comparator.comparingInt(i -> i.intValue()));
        System.out.println(max.get());



    }
}
