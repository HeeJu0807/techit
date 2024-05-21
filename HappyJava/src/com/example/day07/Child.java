package com.example.day07;

public class Child extends Parent{

    // 부모 생성자를 호출해야 함
    public Child(){
        super("no name", 0);
    }

    @Override
    public String toString() {
        return "나는 Child 입니다.";
    }

    @Override
    public String getName() {
        System.out.println("나는 자식클래스에서 구현한 getName()입니다.");
        return super.getName();
    }
}
