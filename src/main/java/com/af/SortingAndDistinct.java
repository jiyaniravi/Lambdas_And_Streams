package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingAndDistinct {
    public static void main(String[] args) {
        printDistinctAndSortedValues(
                new ArrayList<>(Arrays.asList(5,2,7,4,1,8,4,7,9,4,5,6))
        );
    }

    private static void printDistinctAndSortedValues(List<Integer> numbers){
        numbers.stream().distinct().sorted().forEach(System.out::println);
    }

}
