package com.ohgiraffers.chap01.section01.service;
/**
 * 카카오페이 결제 게이트 웨이 구현체
 * 실제 결제 처리를 담당하는 클래스
 *
 * */
public class KaKaoPayGateway {

    /**
     * 결제를 ㅓ리하는 메소드
     * @param orderId 주문 ID
     * @param amount 결제금액
    * */
 public boolean pay(String orderId, double amount) {
     System.out.println("카카오페이로 결제를 진행합니다. 주문번호 : "+ orderId+ ", 금액 : "+ amount);
     return true;
 }
}
