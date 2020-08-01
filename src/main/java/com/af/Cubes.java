package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cubes {
    public static void main(String[] args) {
        printCubes(new ArrayList<>(Arrays.asList(2,5,4,8,6,9,23,27,56)));
    }

    private static void printCubes(List<Integer> integerList){
        integerList.stream()
                .filter(number -> number%2 != 0)
                .map(number -> (number * number * number))
                .forEach(System.out::println);

    }
}
