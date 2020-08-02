package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodReferencesDemo {
    public static void main(String[] args) {
        List<String> courses = new ArrayList<>(Arrays.asList("Spring","Spring Boot","API","AWS","Azure","PCF","Docker","Kubernetes"));

        courses.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //Constructor Reference
        Supplier<String> supplier = String::new;
    }
}
