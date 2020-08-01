package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingAndDistinct {
    public static void main(String[] args) {
        printDistinctAndSortedIntegers(
                new ArrayList<>(Arrays.asList(5,2,7,4,1,8,4,7,9,4,5,6))
        );

        printDistinctAndSortedStrings(
                new ArrayList<>(Arrays.asList("Spring","Spring Boot","PCF","API","AWS","Azure","PCF","Docker","Kubernetes"))
        );
    }

    private static void printDistinctAndSortedIntegers(List<Integer> numbers){
        //numbers.stream().distinct().sorted().forEach(System.out::println);
        //numbers.stream().distinct().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        numbers.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void printDistinctAndSortedStrings(List<String> courses){
        //courses.stream().distinct().sorted().forEach(System.out::println);
        //courses.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        /*courses.stream()
                .distinct()
                .sorted(Comparator.comparing(course -> course.length()))
                .forEach(System.out::println);*/
        courses.stream()
                .distinct()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }
}
