package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddFinder {

    public static void main(String[] args) {
        findOdd(new ArrayList<>(Arrays.asList(23,45,123,56,34,89,45,34,125)));
    }

    private static void findOdd(List<Integer> list){
        list.stream().filter(number -> number%2 != 0).forEach(System.out::println);
    }
}
