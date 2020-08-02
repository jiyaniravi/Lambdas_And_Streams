package com.af;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Builder(setterPrefix = "with")
class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return name+" : "+noOfStudents+" : "+reviewScore;
    }
}

public class CustomClass {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>(
                Arrays.asList(
                    new Course("Spring", "Framework", 98, 20000),
                    new Course("Spring Boot", "Framework", 95, 18000),
                    new Course("API", "Micro Services", 97, 22000),
                    new Course("Micro Services", "Micro Services", 96, 25000),
                    new Course("FullStack", "FullStack", 91, 14000),
                    new Course("AWS", "Cloud", 92, 25000),
                    new Course("Azure", "Cloud", 99, 21000),
                    new Course("Docker", "Cloud", 92, 28000),
                    Course.builder().withName("Kubernetes").withCategory("Cloud").withReviewScore(98).withNoOfStudents(19000).build()
                )
        );

        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate    = course -> course.getReviewScore() < 90;

        CollectorExamples.printDash();
        System.out.println(
                courses.stream().allMatch(
                        reviewScoreGreaterThan95Predicate
                )
        );
        CollectorExamples.printDash();
        System.out.println(
                courses.stream().noneMatch(
                        reviewScoreGreaterThan95Predicate
                )
        );
        CollectorExamples.printDash();
        System.out.println(
                courses.stream().noneMatch(
                        reviewScoreLessThan90Predicate
                )
        );
        CollectorExamples.printDash();
        System.out.println(
                courses.stream().anyMatch(
                        reviewScoreGreaterThan95Predicate
                )
        );

        Comparator<Course> comparingByNumberOfStudents
                = Comparator.comparingInt(Course::getNoOfStudents);

        Comparator<Course> comparingByNumberOfStudentsDesc
                = Comparator.comparingInt(Course::getNoOfStudents).reversed();

        Comparator<Course> comparingByNumberOfStudentsAndNumberOfReviews
                = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getNoOfStudents);
        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .sorted(comparingByNumberOfStudents)
                        .collect(Collectors.toList())
        );
        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .sorted(comparingByNumberOfStudentsDesc)
                        .collect(Collectors.toList())
        );
        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .sorted(comparingByNumberOfStudentsAndNumberOfReviews)
                        .collect(Collectors.toList())
        );
        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .sorted(comparingByNumberOfStudentsAndNumberOfReviews)
                        .limit(5)
                        .collect(Collectors.toList())
        );
        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .sorted(comparingByNumberOfStudentsAndNumberOfReviews)
                        .skip(2)
                        .collect(Collectors.toList())
        );
        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .sorted(comparingByNumberOfStudentsAndNumberOfReviews)
                        .skip(2)
                        .limit(5)
                        .collect(Collectors.toList())
        );

        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .takeWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );

        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .dropWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );

        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .max(comparingByNumberOfStudentsAndNumberOfReviews)
        );

        System.out.println(
                courses.stream()
                        .min(comparingByNumberOfStudentsAndNumberOfReviews)
        );

        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .min(comparingByNumberOfStudentsAndNumberOfReviews)
        );

        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .min(comparingByNumberOfStudentsAndNumberOfReviews)
                        .orElse(Course.builder()
                                .withName("Default")
                                .withCategory("Default")
                                .withNoOfStudents(50000)
                                .withReviewScore(75).build())
        );

        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .findFirst()
        );
        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .limit(1)
                        .collect(Collectors.toList())
        );

        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan90Predicate)
                        .findFirst()
        );
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan90Predicate)
                        .limit(1)
                        .collect(Collectors.toList())
        );

        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .parallel()
                        .filter(reviewScoreGreaterThan90Predicate)
                        .findAny()
        );

        CollectorExamples.printDash();
        System.out.println(courses.stream()
                                .filter(reviewScoreGreaterThan95Predicate)
                                .mapToInt(Course::getNoOfStudents)
                                .sum());

        CollectorExamples.printDash();
        System.out.println(courses.stream()
                                .filter(reviewScoreGreaterThan95Predicate)
                                .mapToInt(Course::getNoOfStudents)
                                .average());

        CollectorExamples.printDash();
        System.out.println(courses.stream()
                                .filter(reviewScoreGreaterThan95Predicate)
                                .mapToInt(Course::getNoOfStudents)
                                .count());

        CollectorExamples.printDash();
        System.out.println(
            courses.stream()
                    .collect(Collectors.groupingBy(Course::getCategory))
        );

        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );

        CollectorExamples.printDash();
        System.out.println(
                courses.stream()
                        .collect(
                                Collectors.groupingBy(Course::getCategory,
                                                      Collectors.maxBy(
                                                              Comparator.comparing(Course::getReviewScore)
                                                      )
                                        )
                        )
        );
    }
}
