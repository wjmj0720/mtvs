package com.ohgiraffers.chap01requestmapping;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingTestController {

    @RequestMapping("/menu/regist")
    public String menuRegist(Model model) {
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함");
        return "mappingResult";
    }

    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
    public String modifyMenu(Model model) {
        model.addAttribute("message","get 방식의 메뉴 수정용 핸들러 메소드 호출함");
        return "mappingResult";
    }

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model) {
        model.addAttribute("message","get 방식의 삭제용 핸들러 메소드 호출함");
        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model) {
        model.addAttribute("message","post 방식의 삭제용 핸들러 메소드 호출함");
        return "mappingResult";
    }

}
