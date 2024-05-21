package com.example.day16;

class MyFunctionalInterfaceImpl implements MyFunctionalInterface {

    @Override
    public void method1() {
        System.out.println("method1");
    }

//    @Override
//    public void method2() {
//        System.out.println("method2");
//    }
}

public class MyFunctionalInterfaceTest {
    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface;
        MyFunctionalInterface myFunctionalInterface1;
        MyFunctionalInterface myFunctionalInterface2;

        // 익명 내부 클래스를 사용하여 MyFunctionalnterface 를 구현한 객체를 생성하고
        // method1 을 오버라이드하여 method 1 call 출력
        myFunctionalInterface = new MyFunctionalInterface() {
            @Override
            public void method1() {
                System.out.println("method1 call");
            }

//            @Override
//            public void method2() {
//                System.out.println("method 2 call");
//            }
        };


        myFunctionalInterface1 = new MyFunctionalInterfaceImpl();


        myFunctionalInterface2 = () -> System.out.println("method1");

        myFunctionalInterface.method1();
        myFunctionalInterface1.method1();
        myFunctionalInterface2.method1();

        System.out.println("===============");

        myFunctionalInterface2 = () -> System.out.println("hahaha");
        myFunctionalInterface2.method1();

        myFunctionalInterface = new MyFunctionalInterface() {
            @Override
            public void method1() {
                System.out.println("hohoho");
            }
        };
        myFunctionalInterface.method1();

    }
}