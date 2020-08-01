package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseFinder {
    public static void main(String[] args) {
        findCourse(new ArrayList<>(Arrays.asList("Spring","Spring Boot","API","AWS","Azure","Docker","Kubernetes")));
    }

    private static void findCourse(List<String> stringList){
        stringList.stream().forEach(System.out::println);
    }
}
