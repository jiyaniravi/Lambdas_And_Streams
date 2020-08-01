package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorExamples {
    public static void main(String[] args) {
        printDash();
        System.out.println("Get Squared List");
        printDash();
        System.out.println(
                getSquaredList(
                        new ArrayList<>(Arrays.asList(1,2,3,4,5))
                )
        );

        printDash();
        System.out.println("Get Even List");
        printDash();
        System.out.println(
                getEvenList(
                        new ArrayList<>(Arrays.asList(1,2,3,4,5))
                )
        );

        printDash();
        System.out.println("Get course length List");
        printDash();
        System.out.println(
                getListBasedOnCourseLength(
                        new ArrayList<>(Arrays.asList("Spring","Spring Boot","API","AWS","Azure","PCF","Docker","Kubernetes"))
                )
        );
    }

    private static List<Integer> getSquaredList(List<Integer> numbers){
        return numbers.stream().map(number -> number*number).collect(Collectors.toList());
    }

    private static List<Integer> getEvenList(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> number%2==0)
                .collect(Collectors.toList());
    }

    private static List<Integer> getListBasedOnCourseLength(List<String> courses){
        return courses.stream()
                .map(String::length)
                .sorted()
                .collect(Collectors.toList());
    }

    private static void printDash(){
        System.out.println("----------------------------------------------");
    }
}
