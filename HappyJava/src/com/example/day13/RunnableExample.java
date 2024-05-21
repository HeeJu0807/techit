package com.example.day13;

public class RunnableExample implements Runnable {
    String name;

    RunnableExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("새 스레드 시작");
        for(int i = 0 ; i < 5; i++){
            System.out.println(name + " 스레드 실행 중: " + i);

            try{
                Thread.sleep((int)(Math.random() * 1000));
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        System.out.println("새 스레드 종료");
    }

    public static void main(String[] args) {
        System.out.println("main 스레드 시작");

        RunnableExample one = new RunnableExample("영희");
        RunnableExample two = new RunnableExample("철수");

        Thread thread = new Thread(one);
        Thread thread2 = new Thread(two);

        thread.start();
        thread2.start();
        System.out.println("main 스레드 종료");
    }
}
