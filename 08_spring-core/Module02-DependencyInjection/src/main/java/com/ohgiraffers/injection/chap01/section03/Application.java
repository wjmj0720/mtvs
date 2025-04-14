package com.ohgiraffers.injection.chap01.section03;

import com.ohgiraffers.injection.chap01.section03.config.AppConfig;
import com.ohgiraffers.injection.chap01.section03.strategy.constructor.PaymentServiceConstructor;
import com.ohgiraffers.injection.chap01.section03.strategy.field.PaymentServiceField;
import com.ohgiraffers.injection.chap01.section03.strategy.setter.PaymentServiceSetter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("=== 의존성 주입 테스트 ===");
        /*
         * 필드 주입 (Field Injection)
         * - PaymentServiceField에서 @Autowired를 필드에 직접 적용.
         * - 특징: 의존성이 필드에 바로 주입되어 생성자나 세터 없이 동작.
         * - 사용 시나리오: 빠른 프로토타입 개발, 간단한 설정에서 유용.
         * - 주의: 불변성 보장 불가, 테스트 시 Mock 주입 어려움.
         * - 예: KakaoPayGateway가 paymentGatewayField에 주입됨.
         */
        PaymentServiceField fieldService = context.getBean(PaymentServiceField.class);
        fieldService.processPayment("field 100", 100.0);
        System.out.println();

        /*
         * 생성자 주입 (Constructor Injection)
         * - PaymentServiceConstructor에서 @Autowired를 생성자에 적용.
         * - 특징: 의존성이 생성 시점에 주입되며, final로 불변성 보장.
         * - 사용 시나리오: 필수 의존성이 명확한 경우, Spring 권장 방식.
         * - 주의: 의존성 많으면 생성자 길어질 수 있음.
         * - 예: KakaoPayGateway가 paymentGatewayConstructor에 주입됨.
         */
        PaymentServiceConstructor constructorService = context.getBean(PaymentServiceConstructor.class);
        constructorService.processPayment("constructor 200", 200.0);

        System.out.println();


        /*
         * 세터 주입 (Setter Injection)
         * - PaymentServiceSetter에서 @Autowired를 Setter 메서드에 적용.
         * - 특징: 의존성이 Setter를 통해 주입, 런타임에 변경 가능.
         * - 사용 시나리오: 선택적 의존성, 동적 의존성 변경이 필요한 경우.
         * - 주의: 주입 누락 시 null 위험, 불변성 보장 불가.
         * - 예: KakaoPayGateway가 setPaymentGateway()로 paymentGatewaySetter에 주입됨.
         */
        PaymentServiceSetter setterService = context.getBean(PaymentServiceSetter.class);
        setterService.processPayment("setter 300", 300.0);

        ((AnnotationConfigApplicationContext) context).close();
    }
}