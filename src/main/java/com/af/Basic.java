package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic {

    public static void main(String[] args) {
        printAllNumbersInListStructuredApproch(new ArrayList<>(Arrays.asList(12,2,15,16,21,15,23,45,12)));
    }

/*    private static boolean isEven(int i){
        return i%2 == 0;
    }*/

    private static void printAllNumbersInListStructuredApproch(List<Integer> list){

//      list.stream().filter(Basic::isEven).forEach(System.out::println);

        list.stream().filter(number -> number%2 == 0).forEach(System.out::println);
    }
}
