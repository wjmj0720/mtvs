package com.ohgiraffers.chap01.section04.service;

public interface PaymentInterface {

    boolean processPayment(String orderId, double amount);

}
