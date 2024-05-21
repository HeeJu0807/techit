package com.example.day13;

class MyRunnable implements Runnable{   // MyRunnable 은 스레드가 아님
    @Override
    public void run() {
        System.out.println("MyRunnable started");
        // 쓰레드가 해야하는 일
        for(int i = 0; i < 100; i++){
            System.out.println("MyRunnable 안녕!!!");
        }
        System.out.println("MyRunnable finished");
    }
}

public class RunnableExam {
    public static void main(String[] args) {
        System.out.println("main started");

        // 쓰레드 생성
        Thread myThread = new Thread(new MyRunnable());
        myThread.start();

        for(int i = 0; i < 100; i++){
            System.out.println("main 안녕!!!");
        }



        System.out.println("main finished");
    }
}
