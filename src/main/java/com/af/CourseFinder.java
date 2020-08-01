package com.af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseFinder {
    public static void main(String[] args) {
        findCourse(new ArrayList<>(Arrays.asList("Spring","Spring Boot","API","AWS","Azure","PCF","Docker","Kubernetes")));
    }

    private static void findCourse(List<String> stringList){
        //stringList.stream().filter(course  -> course.contains("Spring")).forEach(System.out::println);
        stringList.stream().filter(course  -> course.length() > 4).forEach(System.out::println);
    }
}
