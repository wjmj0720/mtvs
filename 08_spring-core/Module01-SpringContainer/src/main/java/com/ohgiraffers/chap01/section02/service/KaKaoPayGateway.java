package com.ohgiraffers.chap01.section02.service;
/**
 * 카카오페이 결제 게이트 웨이 구현체
 * 실제 결제 처리를 담당하는 클래스
 *
 * */
public class KaKaoPayGateway implements PaymentInterface { //추상클래스 상속 -> 구현책임의 원칙

    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("카카오페이로 결제를 진행합니다. 주문번호 : "+ orderId+ ", 금액 : "+ amount);
        return true;
    }
}

