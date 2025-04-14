package com.ohgiraffers.chap01.section03;

import com.ohgiraffers.chap01.section03.config.AppConfig;
import com.ohgiraffers.chap01.section03.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        String orderId = "order-123";
        double amount = 100.0;
        // 싱글톤 스코프 테스트
        System.out.println("=====싱글톤 스코프 테스트 =====");

        PaymentService singlePay = context.getBean("singlePay",PaymentService.class);
        boolean result = singlePay.processPayment(orderId, amount);
        System.out.println(singlePay.getLastOrderId());

        PaymentService singlePay2 = context.getBean("singlePay",PaymentService.class); // --> 하나의 주소를 같이 참조
        System.out.println(singlePay2.getLastOrderId());

        System.out.println(singlePay == singlePay2);
        System.out.println();


        //프로토타입 스코프 테스트
        System.out.println("=== 프로토타입 스코프 테스트 ===");

        PaymentService protoPay = context.getBean("protoPay",PaymentService.class); //생성타이밍에 스프링컨테이너가 heap에서 생성하고 외부로 던짐 -> 가비지 컬렉터가 회수
        protoPay.processPayment(orderId, amount);
        System.out.println("protoPay의 마지막 주문 : " + protoPay.getLastOrderId() );

        PaymentService protoPay2 = context.getBean("protoPay",PaymentService.class);
        System.out.println("protoPay2의 마지막 주문 : " + protoPay2.getLastOrderId() );

        System.out.println(protoPay == protoPay2);
    }
}
