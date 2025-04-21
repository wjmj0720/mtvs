package com.ohgiraffers.chap05intercepter;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class StopWatchInterceptor implements HandlerInterceptor { //HandlerInterceptor: 인터셉터 기능을 제공하는 인터페이스(추가)
    private final MenuService menuService;

    public StopWatchInterceptor(MenuService menuService) { //생성자 의존성 주입 -> 외부에서 Menuservice 사용가능(추가)
        this.menuService = menuService;
    }

    /* 전처리 메서드 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandler 호출함...");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        return true;
    }

    /*후처리 메서드*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,@Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("post henadler"); //컨트롤러 처리 후, 뷰 렌더링 전에 호출 (추가)
        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");

        long endTime = System.currentTimeMillis();
        modelAndView.addObject("interval", endTime-startTime);

    }
    /* 마지막에 호출하는 메서드 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//모든 요청 처리가 완료된 후 (예외 발생 여부 상관 없이) 호출 (추가)
        System.out.println("after completion 호출함");
        menuService.method();
    }
}