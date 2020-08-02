package com.af;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BinaryOperatorAndSupplierDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15));

        CollectorExamples.printDash();
        BinaryOperator<Integer> sumFuntion = (a,b) -> a+b;
        System.out.println(
                numbers.stream()
                        .reduce(0,sumFuntion)
        );

        CollectorExamples.printDash();
        Supplier<Integer> randomInteger = () -> {
                                                    return new Random().nextInt(1000);
                                                };
        System.out.println(randomInteger.get());

        CollectorExamples.printDash();

        UnaryOperator<Float> countCircleArea = (radius) -> {
            return (float)(Math.PI * radius * radius);
        };
        System.out.println(countCircleArea.apply(2.0f));
    }
}
