package com.ohgiraffers.injection.chap01.section01;

import com.ohgiraffers.injection.chap01.section01.config.AppConfig;
import com.ohgiraffers.injection.chap01.section01.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        String[] beanNames = context.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }

        System.out.println("컴포넌트 스캔 테스트 ");
        PaymentService paymentService = context.getBean("paymentServiceConstructor", PaymentService.class);
        paymentService.processPayment("scan-100", 200.0);

        ((AnnotationConfigApplicationContext) context).close();
    }
}