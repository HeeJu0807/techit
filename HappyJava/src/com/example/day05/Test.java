package com.example.day05;

public class Test {
    public static void main(String[] args){
        System.out.println(ClassA.fieldA);  // 클래스 필드

        // System.out.println(ClassA.fieldB);
        ClassA a = new ClassA();    // 인스턴스화
        System.out.println(a.fieldB);   // 인스턴스 필드


    }
}
