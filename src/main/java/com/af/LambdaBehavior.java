package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaBehavior {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15));

        filterAndPrint(numbers, number -> number % 2 == 0);
        filterAndPrint(numbers, number -> number % 2 != 0);
        filterAndPrint(numbers, number -> number % 3 == 0 );
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> oddPredicate) {
        numbers.stream()
                .filter(oddPredicate)
                .forEach(System.out::println);
    }
}
