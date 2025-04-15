
package com.ohgiraffers.injection.chap01.section01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*
 * PaymentService 클래스
 * - @Service
 *  - @Component의특수화된 형태로, 서비스 계층(Service Layer에 속하는 bean을 나타낸다.
 *  - 역할 : 비즈니스 로직을 처리하는 클래스에 사용하며, spring이 이를 bean으로 등록한다.
 *  - bean: 이름 paymentService
 * */
@Service
public class
PaymentService {
    private final KaKaoPayGateway paymentGateway;

    @Autowired
    public PaymentService(KaKaoPayGateway paymentGateway) {
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
