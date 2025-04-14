package com.ohgiraffers.injection.chap01.section02.service;

import org.springframework.stereotype.Service;


@Service
public class PaymentService {
    private final PaymentInterface paymentGateway;

    public PaymentService(PaymentInterface paymentGateway) {
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