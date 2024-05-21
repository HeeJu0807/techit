package com.example.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamExam3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple","Banana","Cherry","Apple","Cherry","Date");

        // 글자수가 5 이상인 것만 필터링하고, 중복은 제거해서 새로운 리스트로 얻어온다

        //스트림 사용 x
        List<String> filteredWords1 = new ArrayList<>();
        for(String word : words) {
            if(word.length() > 5) {
                if(filteredWords1.contains(word)) { continue;}
                else filteredWords1.add(word);
            }
        }
        System.out.println(filteredWords1);

        //스트림 사용 o
        List<String> filteredWords2 = words.stream()
                .filter(w -> w.length() > 5).distinct().collect(Collectors.toList());
        System.out.println(filteredWords2);

        System.out.println("==================");

        // set 을 이용하여 필터링하는 부분
        Set<String> tmp = Set.copyOf(words);
        List<String> result2 = new ArrayList<>();
        for(String s : tmp){
            if(s.length() >= 5) {
                result2.add(s);
            }
        }
        System.out.println(result2);
        System.out.println("==================");

        //문자열을 대문자로 변환하여 출력
        words.stream().map(word -> word.toUpperCase()).forEach(System.out::println);
        // words.stream().map(String::toUpperCase).forEach(System.out::println);

        int[] intArr = {3,6,4,8,2};

        //각 요소에 3을 곱해서 출력해주세요

        Arrays.stream(intArr).map(num -> num * 3).forEach(System.out::println);
    }
}
