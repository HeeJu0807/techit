package org.example.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 전역적으로 예외처리
@ControllerAdvice
public class GlobalExceptionHandler {
    // 예외 발생 시 로그 기록에 사용
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 특정 예외를 처리하는 메서드 정의
    // Exception.class 를 인자로 받음 --> 모든 종류의 예외를 처리할 수 있는 전역 예외 처리 메서드
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e, Model model){
        logger.error("Server Error ", e);
        System.out.println("error:::::::::::::::::::"+e);
        model.addAttribute("errorMessage",e.getMessage());
        return new ModelAndView("error");
    }
}
