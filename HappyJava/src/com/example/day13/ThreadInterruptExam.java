package com.example.day13;

public class ThreadInterruptExam {
    static class MyThread extends Thread {
        public void run(){
            try {
                for(int i = 0; i < 5; i++){
                    Thread.sleep(1000); // 1초동안 일시정지
                    System.out.println("Processing step " + (i+1));
                }
            }catch (InterruptedException e){
                System.out.println("스레드가 중단되었습니다.");
                return;
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        try {
            Thread.sleep(2500); // 메인 스레드를 2.5초 동안 일시정지
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt(); // 스레드에 인터러브 신호 보내기
    }
}
