package com.example.day10;

import java.util.List;

public class GenericMethodExample3 {

    // 제네릭 메소드 정의
    public static <T> void printFirst(List<? extends T> l) {
        if(!l.isEmpty()){
            T item = l.get(0);  // 첫번째 요소를 가져옴
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        printFirst(integerList);
    }
}
