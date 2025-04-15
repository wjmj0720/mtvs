package com.ohgiraffers.chap01.section01.service;

/*
* 기존 java 개발 방식의 문제점
*
* 1. 강한 결합도
* 2. 객체 생성의 책임 -> PaymentService가 -> kakaoPay에서 -> naverPay로 변경되어야 함.
* */
public class PaymentService {

    private KaKaoPayGateway paymentGateway;//강한 결합도 : 필드에 직접적으로 생성
    private NaverPayGateway payGateway;

    public PaymentService() {
        this.paymentGateway = new KaKaoPayGateway();//강한 결합
        this.payGateway = new NaverPayGateway();
    }

    public boolean processPayment(String orderId, double amount) {
        System.out.println("결제 처리를 시작합니다. 주문id : "+orderId + ", 금액 : "+ amount);
        /*
        boolean result = paymentGateway.pay(orderId, amount);
        if (result) {
            System.out.println("결제가 성공적으로 처리 되었습니다");
        }else{
            System.out.println("결제 처리 중 오류 발생");
        }
        return result;*/

        boolean result = payGateway.processPayment(orderId, amount);
        if (result) {
            System.out.println("결제 성공");
        }else{
            System.out.println("결제 실패");
        }
        return result;
    }
}
