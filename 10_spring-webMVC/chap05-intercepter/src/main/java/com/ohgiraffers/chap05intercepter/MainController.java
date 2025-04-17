package com.ohgiraffers.chap05intercepter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String index() {
        return "main";
    }

    @RequestMapping("/main") //상위 스코프에 /로 되어있기에 @Getmapping으로 해도됨
    public String main() {
        return "main";
    }
}
