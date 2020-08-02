package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionInterfaces {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15));

        Predicate<Integer> evenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return (number % 2 == 0);
            }
        };
        //x -> x % 2 == 0;


        Function<Integer, Integer> squareFuntion = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return (number * number);
            }
        };
        //x -> x * x;


        Consumer<Integer> println = new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.println(number);
            }
        };
        //System.out::println;

        numbers.stream()
                .filter(evenPredicate)
                .map(squareFuntion)
                .forEach(println);
    }
}
