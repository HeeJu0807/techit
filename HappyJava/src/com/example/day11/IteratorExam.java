package com.example.day11;

import java.util.*;

public class IteratorExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("==============");
        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Set<String> set = new HashSet<>();
        set.add("D");
        set.add("E");
        set.add("F");


        Iterator<String> iterator2 = set.iterator();

        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

        for(String s : set){
            System.out.println(s);
        }
    }
}
