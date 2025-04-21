package com.ohgiraffers.chap01requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
*
*
* */
@Controller //클라이언트의 요청을 받을 수 있는 서블릿이됨
@RequestMapping("/order/*") //클래스 레벨에서 정의한 어노테이션 -> order의 모든 요청은 클래스에서 처리할께
public class ClassMappingTestController {

    @GetMapping("/regist") //@GetMapping: order에서 요청이 get방식이면 여기가 응답
    public String registOrder(Model model) {
        model.addAttribute("message", "get 방식의 주문 등록용 핸들러 메소드 호출함");
        return "mappingResult";
    }

    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String modifyDelete(Model model) {
        model.addAttribute("message", "post 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메소드 호출");
        return "mappingResult";
    }

    /*
     * 3. path value (= 서블릿의 pathvariable)
     */
    @GetMapping("/detail/{orderNo}") //이름 정의
    public String selectOrderDetail(@PathVariable("orderNo") String orderNo, Model model) {
        //orderNO라는 키 값을 읽어와서 String orderNo에 넣어줌, 위에 쓴 키값을 무조건 써줘야됨->아니면 오류
        model.addAttribute("message", orderNo);
        return "mappingResult";
    }

    @RequestMapping//참조만, 실제사용x
    public String otherRequest(Model model) {
        model.addAttribute("message", "order 요청이 들어왔는데 아직 기능은 준비하지 않음");
        return "mappingResult";
    }

}


