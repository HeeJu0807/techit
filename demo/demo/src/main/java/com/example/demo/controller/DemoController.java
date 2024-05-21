package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // 지정된 url 에 대한 get 요청을 처리
    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hi")
    public String hi(){
        return "hi~~~ spring boot!!";
    }
}
