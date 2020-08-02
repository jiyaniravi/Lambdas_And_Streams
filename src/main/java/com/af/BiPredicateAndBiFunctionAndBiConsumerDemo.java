package com.af;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiPredicateAndBiFunctionAndBiConsumerDemo {
    public static void main(String[] args) {

        CollectorExamples.printDash();
        BiPredicate<Integer, String> biPredicat = (number, string) -> {
            return (number < 10 && string.length()>5);
        };

        System.out.println(biPredicat.test(5, "Hello World"));
        System.out.println(biPredicat.test(15, "Hello World"));
        CollectorExamples.printDash();

        BiFunction<Integer, String, String> biFunction = (number, string) -> {
            return number + " , " +  string;
        };
        System.out.println(biFunction.apply(5, "value"));
        CollectorExamples.printDash();

        BiConsumer<Integer, String> biConsumer = (number, string) -> {
            System.out.println("number : "+number);
            System.out.println("string : "+string);
        };
        biConsumer.accept(12, "Twelve");
    }
}
