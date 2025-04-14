package com.ohgiraffers.chap01.section02.service;


public class PaymentService implements PaymentInterface {

    private PaymentInterface paymentGateway; //강한 결합도 : 필드에 직접적으로 생성

    public PaymentService(PaymentInterface paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean processPayment(String orderId, double amount) {
        System.out.println("결제 처리를 시작합니다. 주문 ID : "+orderId + ", 금액 : "+ amount);

        boolean result = paymentGateway.processPayment(orderId, amount);
        if (result) {
            System.out.println("결제 성공");
        }else{
            System.out.println("결제 실패");
        }
        return result;
    }
}
