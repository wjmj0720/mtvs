package com.ohgiraffers.injection.chap01.section03.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class KaKaoPayGateway implements PaymentInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("카카오페이로 결제를 합니다. : " + orderId +"가격 " + amount);
        return true;
    }
}