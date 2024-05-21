package com.example.day09;

import jdk.jfr.Event;

public class EventProcessor {
    public void processEvent(String e){
        // 로컬 내부 클래스 정의
        class EventHandler{
            public void handle(){
                System.out.println("처리 중인 이벤트 : " + e);
            }
        }

        // 로컬 내부 클래스의 인스턴스 생성 및 사용
        EventHandler handler = new EventHandler();
        handler.handle();
    }

    public static void main(String[] args) {
        EventProcessor ep = new EventProcessor();
        ep.processEvent("데이터 업데이트");
    }
}
