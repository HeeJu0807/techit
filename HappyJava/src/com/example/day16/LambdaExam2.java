package com.example.day16;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExam2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,2,5,4);

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        });

        System.out.println(numbers);


        // 간소화
        List<Integer> numbers2 = Arrays.asList(1,4,6,7,3);
        Collections.sort(numbers2, (Integer a, Integer b) -> a.compareTo(b));

        numbers2.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer a) {
                System.out.println(a);
            }
        });
    }
}
