package com.ohgiraffers.chap01.section01.service;

public class NaverPayGateway {

    /**
     * 결제를 처리하는 메소드
     * @param orderId 주문 ID
     * @param amount 결제금액
     * @return 결제 성공여부
     * */
    public boolean processPayment(String orderId, double amount) {
        System.out.println("네이버 페이로 결제를 진행합니다. 주문번호 : "+ orderId+ ", 금액 : "+ amount);
        return true;
    }

}
