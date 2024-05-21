package com.example.day11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        int[] numbers = {1,2,3,4,5,6,7,8,9};
        for(int num : numbers){
            list.add(num);
            set.add(num);
        }

        System.out.println(list);
        System.out.println(set);
    }
}
