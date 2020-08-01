package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquareSum {
    public static void main(String[] args) {
        System.out.println(squareAndSumTheList(new ArrayList<>(Arrays.asList(1,2,3,4,5))));
    }

    private static int squareAndSumTheList(List<Integer> numbers){
        return numbers.stream()
                .map(number -> number*number)
                .reduce(0, Integer::sum);
    }
}
