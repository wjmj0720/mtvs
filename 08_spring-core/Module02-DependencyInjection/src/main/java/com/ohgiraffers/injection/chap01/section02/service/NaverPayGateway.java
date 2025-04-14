package com.ohgiraffers.injection.chap01.section02.service;

import org.springframework.stereotype.Component;

@Component
public class NaverPayGateway implements PaymentInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("네이버페이로 결제를 진행합니다 : " +" 주문 id = " + orderId +", 결제 금액 :"+ amount);

        return true;
    }
}