package com.example.day10;

public class GenericMethodExample {
    public static <T> void printArrayElements(T[] array){
        for(T element : array){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5};
        printArrayElements(intArray);

        String[] stringArray = {"hello", "world", "java"};
        printArrayElements(stringArray);
    }
}
