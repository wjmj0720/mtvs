package com.ohgiraffers.injection.chap01.section03.strategy.constructor;

import com.ohgiraffers.injection.chap01.section03.service.NaverPayGateway;
import com.ohgiraffers.injection.chap01.section03.service.PaymentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 생성자 주입 (Constructor Injection)
 * - @Autowired를 생성자에 적용하여 의존성 주입.
 * - 장점:
 *   1. 불변성 보장: final 키워드로 의존성 변경 방지.
 *   2. 필수 의존성 강제: 주입 없으면 객체 생성 불가, 컴파일 시점에 오류 확인.
 *   3. 테스트 용이성: 의존성을 명시적으로 전달 가능 (Mock 객체 주입 쉬움).
 *   4. 의존성 명확성: 코드만 봐도 필요한 의존성이 드러남.
 * - 단점:
 *   1. 의존성 많을 시 생성자 길어짐: 파라미터 증가.
 * - 예: PaymentInterface가 필수적인 경우, Spring 공식 권장 방식.
 */
@Service
public class PaymentServiceConstructor {
    private final PaymentInterface paymentGateway;

    @Autowired
    public PaymentServiceConstructor(PaymentInterface paymentGateway) {
        this.paymentGateway = paymentGateway;
    }


    public boolean processPayment(String orderId, double amount) {
        System.out.println(" 결제 처리를 시작 합니다.주문 id : "+ orderId+", 금액 : " +amount);
        boolean result = paymentGateway.processPayment(orderId, amount);

        if (result) {
            System.out.println("결제가 성공되었습니다.");
        }else{
            System.out.println("결제가 실패되었습니다.");
        }
        return result;
    }
}