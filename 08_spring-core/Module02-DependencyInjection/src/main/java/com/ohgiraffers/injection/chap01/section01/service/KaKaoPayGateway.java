package com.ohgiraffers.injection.chap01.section01.service;

import org.springframework.stereotype.Component;

/*
* @Component
* - spring이 클래스를 컴포넌트로 인식하여 bean으로 등록하도록 지시한다
* - 역할 : 일반적인 bean을 정의하며, spring 컨테이너가 관리할 책임을 나타낸다.
* - bean 이름 : 기본값은 클래스명 첫 글자 소문자(kakaoPayGateway)
* */

@Component
public class KaKaoPayGateway implements PaymentInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("카카오 페이로 결제를 합니다 : "+orderId+"가격 : "+amount);
        return true;
    }
}
