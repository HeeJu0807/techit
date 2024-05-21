package com.example.day11;

import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueCharacters {
    public static void main(String[] args) {
        String input = "banana";
        Set<Character> set = new LinkedHashSet<>();

        for(char c : input.toCharArray()) {
            set.add(c);
        }

        // 순서 유지하면서 중복 제거된 문자 출력
        System.out.print("Unique characters: ");
        for(char c : set) {
            System.out.print(c + " ");
        }
    }
}
