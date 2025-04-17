package com.ohgiraffers.chap04exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException ex){
        System.out.println("global 레벨에서 exception 처리");
        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String memberRegistExceptionHandler(Model model, MemberRegistException ex){
        System.out.println("global 레벨의 exception 처리");
        model.addAttribute("exception", ex);

        return "error/memberRegist";
    }

    @ExceptionHandler(Exception.class)
    public String nullPointerExceptionHandler(Exception ex){
        return "error/default";
    }

}
