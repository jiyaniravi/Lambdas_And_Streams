package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumUsingFunctionalProgramming {

    public static void main(String[] args) {
        System.out.println(sumListElements(new ArrayList<>(Arrays.asList(4,5,6))));
    }

    private static int sumListElements(List<Integer> integers){
        /*return integers.stream().reduce(0, Integer::sum);*/
        return integers.stream().reduce(0, (a,b) -> (a+b));
    }

}
