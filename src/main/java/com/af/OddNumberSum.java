package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddNumberSum {
    public static void main(String[] args) {
        System.out.println(sumOddNumbers(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9))));
    }
    private static int sumOddNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> number%2!=0)
                .reduce(0, Integer::sum);
    }
}
