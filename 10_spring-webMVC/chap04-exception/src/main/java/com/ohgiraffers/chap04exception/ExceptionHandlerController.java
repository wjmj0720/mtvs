package com.ohgiraffers.chap04exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {
    @GetMapping("controller-null")
    public String nullPointerExceptionTest(){
        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }

    @ExceptionHandler(NullPointerException.class) //nullpointerexception 발생시 처리 핸들러 -> 클래스 레벨에서 발생한 exception 처리
    public String nullPointerExceptionHandler(NullPointerException ex){
        System.out.println("controller 레벨의 exception처리");

        return "error/nullPointer";
    }

    @GetMapping("controller-user")
    public String controllerUser() throws MemberRegistException{ //상속

        boolean check = true;
        if(check){
            throw new MemberRegistException("당신은 회원이 될 수 없습니다."); //에러를 의도적으로 발생
        }
        return "/"; //기본경로 요청
    }

    @ExceptionHandler(MemberRegistException.class) //콘솔창에서 확인 가능 -> exception 감지 -> 클래스 레벨에서 먼저 -> 어플리케이션 전체에서 확인
    public String memberRegistException(Model model, MemberRegistException ex){ //매개변수로 전달 받음
        System.out.println("controller 레벨의 exception 처리");
        model.addAttribute("exception", ex);
        return "error/memberRegist";
    }

}
