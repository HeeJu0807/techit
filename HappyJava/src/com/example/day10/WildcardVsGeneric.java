package com.example.day10;

import java.util.List;
import java.util.ArrayList;

public class WildcardVsGeneric {
    public static void addNumber(List<?> list){
        // list.add(1);
        // 컴파일 오류 발생
        // ? 는 알 수 없는 타입이므로 안전하지 않은 연산으로 간주
    }

    public static <T> void addNumberGeneric(List<T> list, T element){
        list.add(element);
        // 컴파일 성공
        // T 는 명확한 타입으로 간주되며, 메소드 호출 시점에서 타입 결정
    }

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        // addNumber(intList); // 유효하지 않은 작업
        // addNumber(stringList); // 유효하지 않은 작업

        addNumberGeneric(intList, 10); // 이 메소드 호출은 성공하며, 리스트에 정수 10을 추가한다.
        addNumberGeneric(stringList, "Hello"); // 이 메소드 호출은 성공하며, 리스트에 문자열 "Hello"를 추가한다.

        System.out.println(intList); // 출력: [10]
        System.out.println(stringList); // 출력: [Hello]
    }
}
